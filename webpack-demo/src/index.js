
import { useState } from 'react';
import { createRoot } from 'react-dom/client';

function App() {
    const element = document.createElement('div');
    element.setAttribute("id", "root");
    return element;
}
document.body.appendChild(App());


function Counter() {
  const [count, setCount] = useState(0);
  return (
    <div>
      <h1>{count}</h1>
      <button onClick={() => setCount(count + 1)}>
        Increment
      </button>
    </div>
  );
}

// function CounterButton() {
//     const [count, setCount] = useState(0);
//     return e(
//         'div',
//         { onClick: () => setCount(count + 1) },
//         e(
//             'div',
//             {
//                 id: 'v',
//                 className: 'v',
//                 style: {color: 'red', fontSize: '20px'},
//             },
//             'Counter:',
//             e('ul', {},
//                 [
//                     e('li', { style: {color: 'brown' }}, count),
//                     e('li', { style: {color: 'green' }}, count),
//                     e('li', { style: {color: 'blue' }}, count)
//                 ]
//             ),
//             e(
//                 'button',
//                 {},
//                 count
//             ),
            
//         ),                
//     )
// }


const root = createRoot(document.getElementById('root'));
root.render(<Counter />);

