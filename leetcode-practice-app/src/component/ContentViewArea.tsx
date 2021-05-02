import Editor from "@monaco-editor/react";
import React from "react";

interface ContentViewAreaProps {
  fileName: string;
  content: string;
}

export const ContentViewArea = ({
  content,
  fileName,
}: ContentViewAreaProps) => {
  function extractExtentioFromFileName() {
    switch (fileName.split(".")[2]) {
      case "py":
        return "python";
      case "js":
        return "javascript";
      case "cpp":
        return "c++";
      case "java":
        return "java";
      default:
        alert("something error occured!");
    }
  }

  return (
    <div style={{ margin: "1em" }}>
      {/* <pre style={{ fontFamily: "monospace", fontSize: "14px" }}>{content}</pre> */}

      {fileName ? (
        <Editor
          height="90vh"
          defaultLanguage={extractExtentioFromFileName()}
          defaultValue=""
          value={content}
          options={{ readOnly: true }}
        />
      ) : (
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            justifyItems: "center",
            marginTop: "15em",
          }}
        >
          <div>Select any question</div>
        </div>
      )}
    </div>
  );
};
