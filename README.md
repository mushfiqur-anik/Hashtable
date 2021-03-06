# Hashtable 
This repository contains the files for Hashtable project done for the Data Structure course comp-352

## Description 
This project explores the performances of various types of collision resolving mechanism for data structure Hashtable and the influence of the load factor (the number of elements added to the table vs the size of the table) on their performances. The three mechanisms used for this project are [**Linear Probing**](https://en.wikipedia.org/wiki/Linear_probing) (If the indexed location is filled it looks at the next location k+1,k+2, k+3 and so on..), [**Quadratic Probing**](https://en.wikipedia.org/wiki/Quadratic_probing) (considers the locations at indices k + j2, looks at indices k, k+1, k+4, k+9 and so on..), and the last one is [**Separate Chaining**](https://en.wikipedia.org/wiki/Hash_table#Separate_chaining) (Each location contains a data-structure array, linkedlists, etc. searches/puts data inside the data-structure). These techniques are implemented inside LinearProbing.java, QuadraticProbing.java, and SepareChaining.java respectively and Driver.java has been provided to test out the performances.

* Driver.java 
* Hashtable.java
* LinearProbing.java 
* MapElements.java 
* QuadraticProbing.java
* SeparateChaining.java

## Built with 

* [**Java**](https://en.wikipedia.org/wiki/Java_(programming_language)) - The programming language used
* [**Eclipse**](https://en.wikipedia.org/wiki/Eclipse_(software)) - The IDE used 

## Author(s)

* [**Mushfiqur Anik**](https://github.com/mushfiqur-anik)

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
