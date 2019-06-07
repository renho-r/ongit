const pizza = true;
// pizza = false;

var topic = 'JavaScript';
if(topic) {
  let topic = 'React';
  console.log('block', topic);
}

console.info('global', topic);

const a = 'a', b = 'b', c = 'c';
console.info(`${a}, ${b}, ${c}`);

function defaultParamFunc(p1 = 'p1', p2 = 'p2', p3 = 'p3') {
  console.info(p1, p2, p3);
}

defaultParamFunc(a, b);
defaultParamFunc(a, b, undefined);

var lordify = firstname => `${firstname} of Canterbury`
console.info(lordify("fn"))

var sandwich = {
  bread: 'dutch crunch',
  meat: 'tuna',
  cheese: 'swiss',
  toppings: ['lettuce', 'tomato', 'mustard']
}
var {bread, meat} = sandwich;
console.info(bread, meat)

var mg = {bread, meat};
console.info(mg)

var peaks = ['Tallac', 'Ralston', 'Rose']
var canyons = ['Ward', 'Blackwood']
var tahoe = [...peaks, ...canyons]
console.info(tahoe)
