import api from './apiBoolF1'

const getDrivers = () => api.get("/api/drivers")

const getDriverById = (id) => api.get("/api/drivers/" + id)

export default { getDrivers, getDriverById }