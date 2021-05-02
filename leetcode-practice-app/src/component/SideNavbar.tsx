import React from "react";
import { SolutionInterface, solutions } from "../data";

interface SideNavbarProps {
  setContent: React.Dispatch<React.SetStateAction<string>>;
}

export const SideNavbar = ({ setContent }: SideNavbarProps) => {
  const [searchTxt, setSearch] = React.useState("");
  return (
    <div>
      <aside
        style={{
          position: "fixed",
          top: "0",
          bottom: "0",
          overflowY: "scroll",
          background: "#051061",
          color: "white",
          width: "473px",
        }}
      >
        <table>
          <thead>
            <div
              style={{
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                flexFlow: "column",
              }}
            >
              <div>
                <th style={{ paddingTop: "10px" }}>Problem Name</th>
              </div>
              <div style={{ width: "70%" }}>
                {" "}
                <input
                  style={{
                    minWidth: "100%",
                    marginTop: "6px",
                    marginBottom: "8px",
                    padding: "6px",
                    outline: "none",
                  }}
                  placeholder="search question..."
                  type="text"
                  value={searchTxt}
                  onChange={(e) => setSearch(e.target.value.toLowerCase())}
                />{" "}
              </div>
            </div>
          </thead>

          <tbody>
            {solutions
              .filter((data) => data.Name.toLowerCase().includes(searchTxt))
              .map((solution: SolutionInterface) => (
                <div style={{ marginTop: "2px", cursor: "pointer" }}>
                  <tr
                    onClick={() =>
                      setContent((data: string) => (data = solution.Content))
                    }
                    key={solution.ID}
                  >
                    <td> {solution.Name} </td>
                  </tr>
                </div>
              ))}
          </tbody>
        </table>
      </aside>
    </div>
  );
};
