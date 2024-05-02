import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Category from "./Pages/Category";
import Find from "./Pages/Find";
import Home from "./Pages/Home";
import Item from "./Pages/Item";
import Similar from "./Pages/Similar";
import Dashboard from "./Pages/Parking/Dashboard";
import HistoryTable from "./Pages/Parking/HistoryTable";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/find" element={<Find />} />
          <Route path="/category/:id" element={<Category />} />
          <Route path="/item/:id" element={<Item />} />
          <Route path="/similar/:name" element={<Similar />} />

          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/history" element={<HistoryTable />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

