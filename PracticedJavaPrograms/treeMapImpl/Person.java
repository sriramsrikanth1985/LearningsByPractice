package treeMapImpl;

import java.util.TreeMap;
/**
 *
 * @author Ganesh.Rashinker
 *
 */
class Person implements Comparable {
 private int id;

 public Person() {
  super();
  // TODO Auto-generated constructor stub
 }
 public Person(int id) {
  super();
  this.id = id;
 }
 public int getId() {
  return id;
 }
 public void setId(int id) {
  this.id = id;
 }
 @Override
 public String toString() {
  return "Person [id=" + id + "]";
 }

 public int compareTo(Object o) {
  Person p = (Person) o;
  if (this.id == p.id)
   return 0;
  else if (this.id > p.id)
   return 1;
  else
   return -1;
 }

}
