import { useState } from "react";
import Header from "./Components/Header";
import SearchBox from "./Components/SearchBox";
import ResultCard from "./Components/ResultCard";
import Loading from "./Components/Loading";
import { analyzeGithub } from "./services/githubService";
import "./styles/app.css";

export default function App() {
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const handleSearch = async (username) => {
    setLoading(true);
    setError("");
    setData(null);

    try {
      const result = await analyzeGithub(username);
      setData(result);
    } catch (err) {
      console.error(err);
      setError("Usuário não encontrado ou erro na API.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="app">
      <Header />

      <main className="container">
        <SearchBox onSearch={handleSearch} />

        {loading && <Loading />}
        {error && <p className="error">{error}</p>}
        {data && <ResultCard data={data} />}
      </main>
    </div>
  );
}
