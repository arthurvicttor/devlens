export async function analyzeGithub(username) {
  const response = await fetch(
    `http://localhost:8080/api/github/analyze/${username}`,
  );

  if (!response.ok) {
    throw new Error("Erro ao buscar dados");
  }

  return response.json();
}
