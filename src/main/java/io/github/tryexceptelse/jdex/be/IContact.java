package io.github.tryexceptelse.jdex.be;

import io.github.tryexceptelse.jdex.be.entries.FirstName;
import io.github.tryexceptelse.jdex.be.entries.LastName;

/**
 * Contact Interface. These methods will be called by frontend elements,
 * and so need to be accessible and react predictably
 */
public interface IContact
{
    LastName getLast();
    FirstName getFirst();
}