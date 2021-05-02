import React from "react";

interface ContentViewAreaProps {
  content: string;
}

export const ContentViewArea = ({ content }: ContentViewAreaProps) => {
  return (
    <div style={{ margin: "1em" }}>
      <pre style={{ fontFamily: "monospace", fontSize: "14px" }}>{content}</pre>
    </div>
  );
};
