import "./Sidebar.css";
import { assets } from "../../assets/assets";
import { useState } from "react";
import { useGemini } from "../../context/Context";

const Sidebar = () => {
  const [extend, setExtend] = useState(false);
  const { state, dispatch, onSent } = useGemini();
  const newChat = () => {
    dispatch({ type: "RESETRESULT" });
    dispatch({ type: "RESETLOADING" });
  };

  return (
    <aside className="sidebar">
      <div className="top">
        <div className="menu-icon">
          <img
            src={assets.menu_icon}
            alt="menu-icon"
            className="menu"
            onClick={() => setExtend((prev) => !prev)}
          />
        </div>
        <div className="new-chat" onClick={newChat}>
          <img src={assets.plus_icon} alt="plus-icon" />
          {extend && <p>New chat</p>}
        </div>
        {extend && state.previousPrompt.length > 0 && (
          <div className="recent">
            <p className="recent-title">Recent</p>
            {state.previousPrompt.map((prompt, index) => (
              <div
                className="recent-entry"
                key={index}
                onClick={() => onSent(prompt)}
              >
                <img src={assets.message_icon} alt="message-icon" />
                <p>{prompt}</p>
              </div>
            ))}
          </div>
        )}
      </div>
      <div className="bottom">
        <div className="bottom-item recent-entry">
          <img src={assets.question_icon} alt="question-icon" />
          {extend && <p>Help</p>}
        </div>
        <div className="bottom-item recent-entry">
          <img src={assets.history_icon} alt="history-icon" />
          {extend && <p>Activity</p>}
        </div>
        <div className="bottom-item recent-entry">
          <img src={assets.setting_icon} alt="setting-icon" />
          {extend && <p>Settings</p>}
        </div>
      </div>
    </aside>
  );
};

export default Sidebar;
