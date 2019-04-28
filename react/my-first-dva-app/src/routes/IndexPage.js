import React, { Component } from 'react';
import { Button } from 'antd';
import { Table } from 'antd';
import { connect } from 'dva';

class IndexPage extends Component{

  //点击按钮触发
  changeData = () => {
    const { dispatch } = this.props;
    dispatch({
      type: 'indexpage/addUser',
      payload: {},
    });
  };

  render() {
    const { columns, data } = this.props.indexpage; //获取indexpage中的state
    console.log(this.props);
    return (
      <div>
        <Button type="primary" onClick={this.changeData}>修改数据</Button>
        <div>
          <Table columns={columns} dataSource={data}/>
        </div>
      </div>
    )
  }
}

export default connect(({ indexpage }) => ({
  indexpage,
}))(IndexPage);
