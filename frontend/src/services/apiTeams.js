import api from './apiBoolF1'

const getTeams = () => api.get("/api/teams")

const getTeamsById = (id) => api.get("/api/teams/" + id)

export default { getTeams, getTeamsById }