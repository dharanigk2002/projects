import { assets } from "../../assets/assets";
import { useGemini } from "../../context/Context";
import "./Main.css";

const Main = () => {
  const { state, dispatch, onSent } = useGemini();

  return (
    <main className="main-content">
      <nav>
        <p>Gemini</p>
        <img src={assets.user_icon} alt="user" />
      </nav>
      <div className="main-container">
        {!state.showResult && !state.loading ? (
          <>
            <div className="greet">
              <p>
                <span>Hello, Dev</span>
              </p>
              <p>How can I help you today</p>
            </div>
            <div className="cards">
              <div className="card">
                <p>Suggest some beautiful places to explore</p>
                <img src={assets.compass_icon} alt="compass-icon" />
              </div>
              <div className="card">
                <p>Briefly summarize this concept</p>
                <img src={assets.bulb_icon} alt="compass-icon" />
              </div>
              <div className="card">
                <p>Brainstorm some useful tips</p>
                <img src={assets.message_icon} alt="compass-icon" />
              </div>
              <div className="card">
                <p>Suggest some beautiful places to explore</p>
                <img src={assets.code_icon} alt="compass-icon" />
                <p>{state.recentPrompt}</p>
              </div>
            </div>
          </>
        ) : (
          <div className="result">
            <div className="result-title">
              <img src={assets.user_icon} alt="user-icon" />
              <p>{state.recentPrompt}</p>
            </div>
            <div className="result-data">
              <img src={assets.gemini_icon} alt="gemini_icon" />
              {state.loading ? (
                <div className="loader">
                  <hr />
                  <hr />
                  <hr />
                </div>
              ) : (
                <p dangerouslySetInnerHTML={{ __html: state.resultData }}></p>
              )}
            </div>
          </div>
        )}

        <div className="main-bottom">
          <div className="search-box">
            <form
              onSubmit={(e) => {
                e.preventDefault();
                state.input && onSent(state.input);
              }}
            >
              <input
                type="text"
                value={state.input}
                onChange={(e) =>
                  dispatch({ type: "UPDATE", payload: e.target.value })
                }
                placeholder="Enter a prompt here"
              />
            </form>
            <div>
              <img src={assets.gallery_icon} alt="gallery-icon" />
              <img src={assets.mic_icon} alt="mic-icon" />
              {state.input && (
                <img
                  onClick={() => {
                    onSent(state.input);
                  }}
                  src={assets.send_icon}
                  alt="send-icon"
                />
              )}
            </div>
          </div>
          <p className="bottom-info">
            Gemini may display inaccurate info, including about people, so
            double-check its responses. Your privacy and gemini apps
          </p>
        </div>
      </div>
    </main>
  );
};

export default Main;
