export default function ResultCard({ data }) {
  if (!data) return null;

  return (
    <div className="card">
      <h2>{data.name}</h2>

      <p>
        <strong>Total de Repositórios:</strong> {data.totalRepositories}
      </p>

      <div>
        <strong>Linguagens:</strong>
        <ul>
          {data.languages &&
            Object.entries(data.languages).map(([lang, count]) => (
              <li key={lang}>
                {lang} <span style={{ opacity: 0.7 }}>({count})</span>
              </li>
            ))}
        </ul>
      </div>

      <p>
        <strong>Score:</strong> {data.score}
      </p>

      <div>
        <strong>Strengths:</strong>
        <ul>
          {data.strengths?.map((s) => (
            <li key={s}>{s}</li>
          ))}
        </ul>
      </div>

      <div>
        <strong>Suggestions:</strong>
        <ul>
          {data.suggestions?.map((s) => (
            <li key={s}>{s}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}
