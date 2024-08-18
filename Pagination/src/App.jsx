import { useState } from "react";
import data from "../public/Data.json";
import "./App.css";

const App = () => {
  const [currentPage, setCurrentPage] = useState(1);
  const recordsPerPage = 5;
  const lastIndex = currentPage * recordsPerPage;
  const firstIndex = lastIndex - recordsPerPage;
  const records = data.slice(firstIndex, lastIndex);
  const nPage = Math.ceil(data.length / recordsPerPage);
  const page = [...Array(nPage).keys()];

  const prevPage = () => {
    currentPage > 1 && (setCurrentPage(currentPage - 1)) 
  }

  const nextPage = () => {
    currentPage < nPage && (setCurrentPage(currentPage + 1)) 
  }

  const turnPage = (id) => {
    setCurrentPage(id);
  }

  return (
    <main className="container">
      <div className="table">
        <ul className="row">
          <li>
            <strong>ID#</strong>
          </li>
          <li>
            <strong>Name</strong>
          </li>
          <li>
            <strong>Age</strong>
          </li>
          <li>
            <strong>Salary</strong>
          </li>
        </ul>
        {records.map((d) => (
          <ul className="row" key={d.ID}>
            <li>{d.ID}</li>
            <li>{d.name}</li>
            <li>{d.age}</li>
            <li>{d.salary}</li>
          </ul>
        ))}
      </div>
      <ul className="pagination">
        <li>
          <button onClick={prevPage}>prev</button>
        </li>
        {page.map((p) => (
          <li key={p}>
            <button
              onClick={() => turnPage(p + 1)}
              className={`${currentPage === p + 1 && "active"}`}
            >
              {p + 1}
            </button>
          </li>
        ))}
        <li>
          <button onClick={nextPage}>next</button>
        </li>
      </ul>
    </main>
  );
};

export default App;
