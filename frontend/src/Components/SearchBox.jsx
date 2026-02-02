import { useState } from "react";

export default function SearchBox({ onSearch }) {
  const [username, setUsername] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (username.trim()) {
      onSearch(username);
    }
  };

  return (
    <form className="search-box" onSubmit={handleSubmit}>
      <input
        placeholder="Digite o username do GitHub"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <button type="submit">Analisar</button>
    </form>
  );
}
