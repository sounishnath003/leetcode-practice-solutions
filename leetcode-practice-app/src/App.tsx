import React from "react";
import { ContentViewArea, SideNavbar } from "./component";

const App = () => {
  const [content, setContent] = React.useState("");
  const [fileName, setFileName] = React.useState("");
  
  return (
    <div>
      <div>
        <div className="grid-container">
          <SideNavbar setContent={setContent} setFileName={setFileName}/>
          <ContentViewArea content={content} fileName={fileName} />
        </div>
      </div>
    </div>
  );
};

export default App;
