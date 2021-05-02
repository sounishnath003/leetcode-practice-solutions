import React from "react";
import { ContentViewArea, SideNavbar } from "./component";

const App = () => {
  const [content, setContent] = React.useState("");
  
  return (
    <div>
      <div>
        <div className="grid-container">
          <SideNavbar setContent={setContent}/>
          <ContentViewArea content={content} />
        </div>
      </div>
    </div>
  );
};

export default App;
