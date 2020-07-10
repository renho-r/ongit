import { getUser } from '../services/user';
export default {
  namespace: 'indexpage',
  state: {
    columns: [{
      title: '姓名',
      dataIndex: 'name',
    }, {
      title: '性别',
      dataIndex: 'gender',
    }],
    data: [{
      "key": "1",
      "name": "王大斌",
      "gender": "男"
    }, {
      "key": "2",
      "name": "刘小洋",
      "gender": "男"
    }]
  },
  subscriptions: {},

  effects: {
    *addUser({ payload }, { call, put }) {  // eslint-disable-line
      const myuser = yield call(getUser, {});
      yield put({
        type: 'ADD_USER',
        payload: {
          myuser: myuser.data
        },
      });
    },
  },

  reducers: {
    ADD_USER(state, action) {
      return { ...state,
        data:state.data.concat(action.payload.myuser) };
    }
  },
};
