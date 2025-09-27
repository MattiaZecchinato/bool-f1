import axios from 'axios'

const { VITE_BE_PATH } = import.meta.env

const api = axios.create({
    baseURL: VITE_BE_PATH,
    headers: {
        "Content-Type": "application/json"
    }
})

export default api