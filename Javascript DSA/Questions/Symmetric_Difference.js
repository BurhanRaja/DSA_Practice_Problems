function sym(...args) {
  let curr = arguments[0];
  for (let i = 1; i < arguments.length; i++) {
      let array = []
    for (let j = 0; j < arguments[i].length; j++) {
        if (!curr.includes(arguments[i][j])) {
            array.push(arguments[i][j])
        }
    }
    for (let j = 0; j < curr.length; j++) {
        if (!arguments[i].includes(curr[j])) {
            array.push(curr[j])
        }
    }
    curr = array;
  }

  console.log(curr)
}

sym([1, 2, 3], [5, 2, 1, 4], [3, 5, 1]);