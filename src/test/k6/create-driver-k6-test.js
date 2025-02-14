import { check } from 'k6';
import http from 'k6/http';
import {
  randomString
} from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

const host = 'localhost';
const port = '8080';
const endpoint = '/drivers'

export default function () {
    let payload = JSON.stringify({
        name:  `John ${randomString(32)}`,
    });

    let params = { headers: { "Content-Type": "application/json" } };
    let res = http.post(`http://${host}:${port}${endpoint}`, payload, params);

    check(res, { 'is status 200': (r) => r.status === 200 });
}
