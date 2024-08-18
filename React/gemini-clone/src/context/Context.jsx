import { createContext, useContext, useReducer } from "react";
import run from "../config/gemini";

const GeminiContext = createContext(null);

const GeminiContextProvider = ({ children }) => {
  const onSent = async (prompt) => {
    try {
      dispatch({ type: "SETRESULT" });
      dispatch({ type: "SETLOADING" });
      dispatch({ type: "RESETRESULTDATA" });
      dispatch({ type: "SETRECENTPROMPT", payload: prompt });
      (!state.previousPrompt.includes(prompt)) && dispatch({ type: "PREV" })
      const response = await run(prompt);
      const receivedResponse = response.replaceAll("##", '');
      let updatedResponse = '';
      receivedResponse.split('**').forEach((word, index) => {
        if(index % 2 === 0)
            updatedResponse += word;
        else
            updatedResponse += `<b>${word}</b>`;
      })
      let newResponse = updatedResponse.split('*').join('<br>');
      newResponse = newResponse.split(" ");
      newResponse.forEach((word, i) => {
        let nextWord = word + " ";
        setTimeout(() => {
            dispatch({ type: "SETRESULTDATA", payload: nextWord })
        }, 75*i)
      })
      dispatch({ type: "RESETLOADING" });
      dispatch({ type: "CLEAR" });
    } catch (error) {
      console.error(error.message);
    }
  };

  const initialState = {
    input: "",
    recentPrompt: "",
    previousPrompt: [],
    showResult: false,
    loading: false,
    resultData: "",
  };

  const reducer = (state, action) => {
    switch (action.type) {
      case "UPDATE":
        return { ...state, input: action.payload };
      case "CLEAR":
        return { ...state, input: "" };
      case "SETRESULT":
        return { ...state, showResult: true };
      case "RESETRESULT":
        return { ...state, showResult: false };
      case "SETLOADING":
        return { ...state, loading: true };
      case "RESETLOADING":
        return { ...state, loading: false };
      case "RESETRESULTDATA":
        return { ...state, resultData: "" };
      case "SETRESULTDATA":
        return { ...state, resultData: state.resultData + action.payload };
      case "RESETRESULTDATA":
        return { ...state, resultData: '' }
      case "SETRECENTPROMPT":
        return { ...state, recentPrompt: state.input || action.payload };
      case "PREV":
        return { ...state, previousPrompt: [...state.previousPrompt, state.input] }
      default:
        return state;
    }
  };

  const [state, dispatch] = useReducer(reducer, initialState);

  const contextValue = {
    state,
    dispatch,
    onSent,
  };

  return (
    <GeminiContext.Provider value={contextValue}>
      {children}
    </GeminiContext.Provider>
  );
};

export const useGemini = () => {
  return useContext(GeminiContext);
};

export default GeminiContextProvider;
