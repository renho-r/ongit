export default {
  "env": {
    // 开发环境
    "development": {
      "extraBabelPlugins": [
        "dva-hmr",
      ]
    },
    // build 时的生产环境
    "production": {

    }
  },
  extraBabelPlugins: [
    ["import", {
      "libraryName": "antd",
      "libraryDirectory": "es",
      "style": true
    }]
  ]
  // , "proxy": {
  //   "/": {
  //     "target": "http://renho.com",
  //     "changeOrigin": true,
  //     "pathRewrite": { "^/": "" }
  //   }
  // }
}
