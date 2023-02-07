
// Hash Example
let input = [12, 14, 25, 47, 12, 78, 90, 47];
const removeDuplicate = () => {
    const obj = {}
    let count = 0;

    for (const elem of input) {
        if (Object.values(obj).includes(elem)) {
            continue;
        } else {
            obj[`${count}`] = elem;
            count++;
        }
    }
    let arr = [];
    count = 0;
    for (const elem in obj) {
        arr.push(elem);
        count++;
    }
    console.log(arr)
}
removeDuplicate()