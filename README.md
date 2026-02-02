# DevLens 

DevLens é uma aplicação web que analisa perfis do GitHub e gera insights sobre o nível de maturidade técnica de um desenvolvedor com base em seus repositórios públicos.

O projeto consome a API pública do GitHub, processa os dados no backend e apresenta os resultados em um front-end moderno, responsivo e em **dark mode**, com foco em UX simples e direta.

---

## 🚀 Funcionalidades

- 🔎 Busca de usuários do GitHub pelo username
- 📦 Contagem de repositórios públicos (não-forks)
- 🧠 Análise de linguagens utilizadas nos projetos
- ⭐ Cálculo de score técnico baseado em:
  - Quantidade de repositórios
  - Diversidade de linguagens
- 💡 Geração de sugestões automáticas (ex: diversificar projetos)
- 🎨 Interface moderna em modo dark
- 📱 Totalmente responsivo

---

## 🧩 Stack utilizada

### Front-end
- React (componentes funcionais)
- CSS puro (Dark Mode)
- Axios / Fetch API
- Foco em UX e responsividade

### Back-end
- Java
- Spring Boot
- RestTemplate
- API pública do GitHub

---


---

## 🔍 Como funciona a análise

1. O usuário informa um **username do GitHub**
2. O backend consulta:
https://api.github.com/users/%7Busername%7D/repos
3. O sistema:
- Ignora repositórios forkados
- Conta linguagens utilizadas
- Calcula score técnico
4. O frontend exibe:
- Nome do usuário
- Total de repositórios
- Linguagens
- Score
- Pontos fortes
- Sugestões de melhoria

---

## 📊 Regra de Score (exemplo)

- Até **50 pontos** pela quantidade de repositórios
- Até **50 pontos** pela diversidade de linguagens

```java
score += Math.min(totalRepos * 5, 50);
score += Math.min(languages.size() * 10, 50);
