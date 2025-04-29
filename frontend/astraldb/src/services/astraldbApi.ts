import axios from 'axios';
import { getQueryParam } from '../utils/urlUtils';

export function fetchWarpData(url: string) {
  const authkey = getQueryParam(url, 'authkey');
  const authkey_ver = getQueryParam(url, 'authkey_ver');
  const sign_type = getQueryParam(url, 'sign_type');
  const gacha_type = 11;
  
  const apiUrl = 'http://localhost:8080/api/v1/warp_record/getWarpLog';
  const params = { authkey: authkey, authkey_ver: authkey_ver, sign_type: sign_type, gacha_type: gacha_type }; 

  axios.get(apiUrl, { params })
    .then(response => {
        console.log('API Response:', response.data);
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });

}
