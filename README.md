# CSE205-Project2
Simple Tuition Calculation Program - Fictitious 


At Springfield State U there are two categories of students: on-campus students and online students. On-campus students are categorized as residents (R) or nonresidents (N) depending on whether they reside within the state in which Springfield exists or they reside in a different state. The base tuition for on-campus students is $5500 for residents and $12,200 for non-residents. Some on-campus students, enrolled in certain pre-professional programs, are charged an additional program fee which varies depending on the program. An on-campus students may enroll for up to 18 credit hours at the base rate but for each credit hour exceeding 18, they pay an additional fee of $350 for each credit hour over 18.

Online students are neither residents nor non-residents. Rather, their tuition is computed as the number of credit hours for which they are enrolled multiplied by the online credit hour rate which is $875 per credit hours. Furthermore, some online students enrolled in certain degree programs pay an online technology fee of $125 per semester.


Your program shall meet these requirements.

1.	Student information for Springfield State University is stored in a text file named p02-students.txt. There is one student record per line, where the format of a student record for an on-campus student is:

			C id last-name first-name residency program-fee credits

	where:

			'C'			Identifies the student as an on-campus student.
			id 			The student identifier number. A string of 13 digits.
			last-name		The student's last name. A contiguous string of characters.
			first-name	The student's first name. A contiguous string of characters.
			residency		'R' if the student is a resident, 'N' if the student is a non-resident.
			program-fee	A program fee, which may be zero.
			credits		The number of credit hours for which the student is enrolled.

	The format of a student record for an online student is:

			O id last-name first-name tech-fee credits

	where 'O' identifies the student as an online student, and id, last-name, first-name, and credits are the same as for an on-campus student. The tech-fee field is 'T' if the student is to be assessed the technology fee or '-' if the student is not assessed the technology fee.
	Here is an example p02-students.txt file:

	Sample p02-students.txt
	C 8230123345450 Flintstone Fred R 0 12
	C 3873472785863 Simpson Lisa N 750 18
	C 4834324308675 Jetson George R 0 20
	O 1384349045225 Szyslak Moe - 6
	O 5627238253456 Flanders Ned T 3

2.	The program shall read the contents of p02-students.txt and calculate the tuition for each student.

3.	The program shall write the tuition results to an output file named p02-tuition.txt formatted thusly:

			id last-name first-name tuition
			id last-name first-name tuition
			...

	where tuition is the computed tuition for the student. The tuition shall be displayed with two digits after the decimal point. For example:

	Sample p02-tuition.txt
	1384349045225 Szyslak Moe 5250.00	
	3873472785863 Simpson Lisa 12950.00
	4834324308675 Jetson George 6200.00
	5627238253456 Flanders Ned 2750.00
	8230123345450 Flintstone Fred 5500.00

4.	The records in the output file shall be sorted in ascending order by id.

5.	If the input file p02-students.txt cannot be opened for reading (because it does not exist) then display an error message on the output window and immediately terminate the program, e.g.,

	run program
	Sorry, could not open 'p02-students.txt' for reading. Stopping.
