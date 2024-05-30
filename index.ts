/*
* This is the magic squares program.
*
* @author  Andi Cucka
* @version 1.0
* @since   2020-05-06
*/

const NUM3: number = 3;
const NUM4: number = 4;
const NUM5: number = 5;
const NUM6: number = 6;
const NUM7: number = 7;
const NUM8: number = 8;
const NUM9: number = 9;
const MAGIC_SUM: number = 15;

let processCount: number = 0;
let magicSquareCount: number = 0;

function generateSquare(square: number[], usedNumbers: number[], position: number) {
    for (let i = 0; i < square.length; i++) {
        processCount++;
        if (usedNumbers[i] === 0) {
            square[position] = i + 1;
            usedNumbers[i] = 1;

            if (position < square.length - 1) {
                generateSquare(square, usedNumbers, position + 1);
            } else if (isMagicSquare(square)) {
                displayMagicSquare(square);
                magicSquareCount++;
            }
            usedNumbers[i] = 0;
        }
    }
}

function isMagicSquare(square: number[]): boolean {
    const sum1 = square[0] + square[1] + square[2];
    const sum2 = square[NUM3] + square[NUM4] + square[NUM5];
    const sum3 = square[NUM6] + square[NUM7] + square[NUM8];
    const colSum1 = square[0] + square[NUM3] + square[NUM6];
    const colSum2 = square[1] + square[NUM4] + square[NUM7];
    const colSum3 = square[2] + square[NUM5] + square[NUM8];
    const diagSum1 = square[0] + square[NUM4] + square[NUM8];
    const diagSum2 = square[2] + square[NUM4] + square[NUM6];

    return sum1 === MAGIC_SUM && sum2 === MAGIC_SUM && sum3 === MAGIC_SUM &&
        colSum1 === MAGIC_SUM && colSum2 === MAGIC_SUM &&
        colSum3 === MAGIC_SUM && diagSum1 === MAGIC_SUM && diagSum2 === MAGIC_SUM;
}

function displayMagicSquare(square: number[]) {
    console.log("\n*****");
    for (let i = 0; i < square.length; i++) {
        if (i === NUM3 || i === NUM6) {
            console.log();
        }
        process.stdout.write(square[i] + " ");
    }
    console.log("\n*****");
}

// Main execution
const initialSquare: number[] = [1, 2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9];
const helperArray: number[] = Array(9).fill(0);
console.log("\nAll Possible Magic Squares (3x3):\n");
generateSquare(initialSquare, helperArray, 0);
