package edu.cs3500.spreadsheets.provider.model;

//import edu.cs3500.spreadsheets.model.datastructures.visitors.ValueVisitor;

/**
 * A value is one of a Boolean, Double, String, or blank value.
 */
public interface IVal {

  <R> R accept(ValueVisitor<R> evalInstructions) throws IllegalStateException,
          IllegalArgumentException;


}
