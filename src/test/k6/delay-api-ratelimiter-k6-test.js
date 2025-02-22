import { check } from 'k6';
import { sleep } from 'k6';
import http from 'k6/http';
import {
  randomString
} from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

const host = 'localhost';
const port = '8080';
const endpoint = '/delay/5000'

export default function () {
    let res = http.get(`http://${host}:${port}${endpoint}`);

    check(res, { 'is status 200': (r) => r.status === 200 });
    check(res, { 'is not fallback': (r) => !r.json('message').includes('fallback') });
}
