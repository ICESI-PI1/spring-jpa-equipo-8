import axios from 'axios';

const instance = axios.create({baseURL: "http://localhost:8082/"})
const token = localStorage.getItem('token') 

instance.interceptors.request.use(
    (config) => {

      if (token) {
        config.headers['Authorization'] = `Bearer ${token}`;
      }
  
      return config;
    },
    (error) => {
      return Promise.reject(error);
    }
  );

export default instance