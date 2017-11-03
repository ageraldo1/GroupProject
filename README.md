# GroupProject
Group Project repository

run:
***************************************************************************
CSCI 1302: Principles of Computer Science I - Fall 2017
Group Project

		Alexandre Geraldo
		Sidney Williams


***************************************************************************
Press Enter key to continue...

+--------------------------------------+
Choose THREE  Sorting Algorithms below
+--------------------------------------+
	[1] Bogo
	[2] Bubble
	[3] Bucket
	[4] Insertion

Your selection []....: 2,3,4
+--------------------------------------+
Choose TWO Searching Algorithms below
+--------------------------------------+
	[1] Binary Search
	[2] Linear Search
	[3] Jump Search

Your selection []....: 2,3
+--------------------------------------------------------------+
Additional Parameters
+--------------------------------------------------------------+
a) Enter the number of elements of the random array of integers
	Your selection [minimum of 100000 element(s)]....: 300000
b) Enter the number value to be seached into the array or type r for a random number
	Your selection []....: r
	Searching for the number value...: 96887
+--------------------------------------------------------------+
Running Sorting algorithms testing....
Running com.gsu.project.sort.BubbleSort....
Running com.gsu.project.sort.BucketSort....
Running com.gsu.project.sort.InsertionSort....
Running Searching algorithms testing....
Running com.gsu.project.search.LinearSearch....
	Element was found on the array
Running com.gsu.project.search.JumpSearch....
	Element was found on the array
+--------------------------------------------------------+
Performance results
+--------------------------------------------------------+
	Sort algorithm(s)
		Algorithm........:com.gsu.project.sort.InsertionSort
		Time taken(ms)...:8289

		Algorithm........:com.gsu.project.sort.BubbleSort
		Time taken(ms)...:150769

		Algorithm........:com.gsu.project.sort.BucketSort
		Time taken(ms)...:5

	Fastest sort Algorithm...:{com.gsu.project.sort.BucketSort=5}
	Slowest sort Algorithm...:{com.gsu.project.sort.BubbleSort=150769}

	Search algorithm(s)
		Algorithm........:com.gsu.project.search.LinearSearch
		Time taken(ms)...:2

		Algorithm........:com.gsu.project.search.JumpSearch
		Time taken(ms)...:1

	Fastest search Algorithm...:{com.gsu.project.search.JumpSearch=1}
	Slowest search Algorithm...:{com.gsu.project.search.LinearSearch=2}
BUILD SUCCESSFUL (total time: 3 minutes 2 seconds)
