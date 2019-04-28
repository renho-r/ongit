import React from 'react';
import {Router, Route, Switch} from 'dva/router';
import Layout from './components/layout'
import IndexPage from './routes/IndexPage';
import AAA from './routes/aaa';
import BBB from './routes/bbb';

function RouterConfig({history}) {
  return (
    <Router history={history}>
      <Layout>
        <Switch>
          <Route path="/" exact component={IndexPage}/>
          <Route path="/aaa" exact component={AAA}/>
          <Route path="/bbb" exact component={BBB}/>
        </Switch>
      </Layout>
    </Router>
  );
}

export default RouterConfig;
