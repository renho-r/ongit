import Mock from 'mockjs';
import { format, delay } from 'roadhog-api-doc';
// 是否禁用代理
const noProxy = process.env.NO_PROXY === 'true';
const Random = Mock.Random;
const proxy = {
  //具体mock数据
  'GET /data': [Mock.mock({
    'key|1-100': 100,
    'name': 'rrrrr',
    'gender': '女'
  })],
//   'GET /data': [{
//     key: Random.id(),
//     name: Mock.mock({
//       'a|1-100': 100
//     }),
//     gender: "女"
//   }]
}
// export default (noProxy ? {
//   '/*': "https://your.server.com/",
// } : delay(proxy, 1000));
export default (noProxy ? {} : delay(proxy, 1000));
