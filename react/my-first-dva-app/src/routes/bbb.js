// aaa.js
import React, { Component } from 'react'
import { connect } from 'dva'

class BBB extends Component { //BBB同理
  render() {
    return (
      <div>
        <h1>BBB</h1>
      </div>
    )
  }
}

BBB.propsTypes = {}
export default connect()(BBB)
