const students = [
 { id: 1, name: "Rahul", marks: [80, 75, 90] },
 { id: 2, name: "Sneha", marks: [60, 70, 65] },
 { id: 3, name: "Arjun", marks: [95, 92, 88] }
];
//to get just the marks array
const marksArrays = students.map(student => student.marks);
console.log(marksArrays);

//1. Total using reduce
const totals = marksArrays.map(studentMarks => 
  studentMarks.reduce((sum, mark) => sum + mark, 0)
);

console.log(totals); // [245, 195, 275]

// 2. Calculate averages 
const averages = totals.map(total => total / 3).map(avg => avg.toFixed(2));
console.log('Averages:', averages); // ["81.67", "65.00", "91.67"]

// 2. Get grades (A>=90, B>=75, C>=60, Fail<60)
const grades = averages.map(avg => {
  const average = parseFloat(avg);
  if (average >= 90) return 'A';
  if (average >= 75) return 'B';
  if (average >= 60) return 'C';
  return 'Fail';
});
console.log('Grades:', grades); // ["B", "C", "A"]

//3.  Use map() to create a new array with name, total, average, and grade.
const studentSummary = students.map((student, index) => ({
  name: student.name,
  total: totals[index],
  average: averages[index],
  grade: grades[index]
}));
console.log('Student Summary:', studentSummary);

//4.  Use filter() to get students who scored average above 75.
const topStudents = studentSummary.filter(student => parseFloat(student.average) > 75);
console.log('Top Performers (Avg > 75):', topStudents);


// 5. Use forEach() to print all student details
studentSummary.forEach(student => {
  console.log(`${student.name}: Total=${student.total}, Average=${student.average}, Grade=${student.grade}`);
});
