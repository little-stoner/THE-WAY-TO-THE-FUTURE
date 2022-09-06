# CppCoreGuidelines
[guide](http://isocpp.github.io/CppCoreGuidelines/CppCoreGuidelines#S-stdlib)
# Philosophy
- Express ideas directly in code
- Write in ISO Standard C++
- Express intent
- Ideally, a program should be statically type safe
- Prefer compile-time checking to run-time checking
- What cannot be checked at compile time should be checkable
at runtime
- Catch run-time errors early
- Don't leak any resources
- Don't waste time or space
- Prefer immutable data to mutable data
- Encapsulate messy constructs, rather than spreading through
the code
- Use supporting tools as appropriate
- Use support libraries as appropriate

# Interfaces
- Make interfaces explicit
- Avoid non-const global variables
- Avoid singletons
- Make interfaces precisely and strongly typed
- State preconditions (if any)
- Prefer Expects() for expressing preconditions
- State postconditions
- Prefer Ensures() for expressing postconditions
- If an interface is a template, document its parameters
using concepts
- Use exceptions to signal a failure to perform a required task
- Never transfer ownership by a raw pointer(T*) or reference(T&)
- Declare a pointer that must not be null as not_null
- Do not pass an array as a single pointer
- Avoid complex initialization of global objects
- Keep the number of function arguments low
- Avoid adjacent parameters that can be invoked by the 
same arguments in either order with different meaning
- Prefer empty abstract classes as interfaces to class hierarchies
- If you want a cross-compiler ABI, use a C-style subset
- For stable library ABI, consider the Pimpl idiom
- Encapsulate rule violations

# Functions
## Function definitions
- "Package" meaningful operations as carefully named functions
- A Function should perform a single logical operation
- Keep functions short and simple
- If a function might have to be evaluated at compile time
declare it constexpr
- If a function is very small and time-critical, declare it `inline`
- If your function must not throw, declare it `noexcept`
- For general use, take `T*` or `T&` arguments rather than smart pointers
- Prefer pure functions
- Unused parameters should be unnamed
## Parameter passing
- Prefer simple and conventional ways of passing information
- For "in" parameters, pass cheaply-copied types by value and
others by references to `const`
- For "in-out" parameters, pass by reference to non-`const`
- For "will-move-from" parameters, pass by `X&&` and `std::move` the parameter
- For "forward" parameters, pass by `TP&&` and only `std::forward` the parameter
- For "out" output values, prefer return values to output parameters
- To return multiple "out" values, prefer returning a struct or tuple
- Use `T*` or `owner<T*>` to designate a single object
- Use a `not_null<T>` to indicate that "null" is not a valid value
- Use a `span<T>` or a `span_p<T>` to designate a half-open sequence
- Use a `zstring` or a `not_null<zstring>` to designate a C-style string
- Use a `unique_ptr<T>` to transfer ownership where a pointer is needed
- Use a `shared_ptr<T>` to share ownership
- Prefer `T*` over `T&` when "no argument" is a valid option
- Return a `T*` to indicate a position (only)
- Never (directly or indirectly) return a pointer or a 
reference to a local object
- Return a `T&` when copy is undesirable and "returning no object"
isn't needed
- Don't return a `T&&`
- `int` is the return type for `main()`
- Return `T&` from assignment operators
- Don't `return std::move(local)`
- Use a lambda when a function won't do
- When there is a choice, prefer default arguments over
overloading
- Prefer capturing by reference in lambdas that will be
used locally, including passed to algorithms
- Avoid capturing by reference in lambdas that will be used
non-locally, including returned, stored on the heap, or passed
to another thread
- If you capture `this`, capture all variables explicitly
  (no default capture)
- Don't use `va_arg` arguments
- Avoid unnecessary condition nesting

# Classes and class Hierarchies
- Organize related data into structures (`struct`s or `class`es)
- Use `class` if the class has an invariant; use `struct` if the 
data members can vary independently
- Represent the distinction between an interface and an implementation
using a class
- Make a function a member only if it needs direct access to the
representation of a class
- Place helper functions in the same namespace as the class
they support
- Don't define a class or enum and declare a variable of its
type in the same statement
- Use `class` rather than `struct` if any member is non-public
- Minimize exposure of members
## Concrete types
- Prefer concrete types over class hierarchies
- Make concrete types regular
- Don't make data members `const` or references
## Constructors, assignments, and destructors
### Default Operations
- If you can avoid defining default operations, do
- If you define or `=delete` any copy, move, or destructor
function, define or `=delete` them all
- Make default operations consistent
### Destructors
- Define a destructor if a class needs an explicit action
at object destruction
- All resources acquired by a class must be released
by the class's destructor
- If a class has a raw pointer (`T*`) or reference (`T&`)
consider whether it might be owning
- If a class has an owning pointer member, define a destructor
- A base class destructor should be either public
and virtual, or protected and non-virtual
- A destructor must not fail
- Make destructors `noexcept`
### Constructors
- Define a constructor if a class has an invariant
- A constructor should create a fully initialized object
- If a constructor cannot construct a valid object, 
throw an exception
- Ensure that a copyable class has a default constructor
- Prefer default constructors to be simple and non-throwing
- Don't define a default constructor that only initializes
data members; use in-class member initializers instead
- By default, declare single-argument constructors explicit
- Define and initialize member variables in the order of 
member declaration
- Prefer in-class initializers to member initializers
in constructors for constant initializers
- Prefer initialization to assignment in constructors
- Use a factory function if you need "virtual behavior"
during initialization
- Use delegation constructors to represent common actions
for all constructors of a class
- Use inheriting constructors to import constructors
into a derived class that does not need further explicit
initialization
### Copy and move
- Make copy assignment non-`virtual`, take the parameter
by `const&`, and return by non-`const&`
- A copy operation should copy
- Make copy assignment safe for self-assignment
- Make move assignment non-`virtual`, take the parameter
by `&&`, and return by non-`const&`
- A move operation should move and leave its source
in a valid state
- Make move assignment safe for self-assignment
- Make move operations `noexcept`
- A polymorphic class should suppress public copy/move
### Other default operation rules
- Use `=default` if you have to be explicit about using
the default semantics
- Use `=delete` when you want to disable default behavior
  (without wanting an alternative)
- Don't call virtual functions in constructors and destructors
- For value-like types, consider providing a `noexcept`
swap function
- A `swap` function must not fail
- Make `swap noexcept`
- Make `==` symmetric with respect to operand types and `noexcept`
- Beware of `==` on base classes
- Make a `hash` noexcept
- Rely on constructors and assignment operations, not `memset`
and `memcpy`
### Containers and other resource handlers
- Follow the STL when defining a container
- Give a container value semantics
- Give a container move operations
- Give a container an initializer list constructor
- Give a container a default constructor that sets it to empty
- If a resource handle has pointer semantics, provide `*` and `->`

### Function objects and lambdas

### Class hierarchies (OOP)
- Use class hierarchies to represent concepts with
inherent hierarchical structure (only)
- If a base class is used as an interface, make it a pure
abstract class
- Use a abstract classes as interfaces when complete separation
of interface and implementation is needed
#### Designing classes in a hierarchy
- An abstract class typically doesn't need a user-written constructor
- A class with a virtual function should have a virtual or 
protected destructor
- Virtual functions should specify exactly one of `virtual`,
`override`, or `final`
- When designing a class hierarchy, distinguish between
implementation inheritance and interface inheritance
- For making deep copies of polymorphic classes prefer a virtual
`clone` function instead of public `copy` construction/assignment
- Avoid trivial getters and setters
- Don't make a function `virtual` without reason
- Avoid `protected` data
- Ensure all non-`const` data members have the same access level
- Use multiple inheritance to represent multiple distinct interfaces
- Use multiple inheritance to represent the union of implementation
attributes
- Use `virtual` bases to avoid overly general base classes
- Create an overload set for a derived class and its bases with `using`
- Use `final` on classes sparingly
- Do not provide different default arguments for a virtual
function and an overrider
#### Accessing objects in a hierarchy
- Access polymorphic objects through pointers and references
- Use `dynamic_cast` where class hierarchy navigation is unavoidable
- Use `dynamic_cast` to a reference type when failure to find the 
required class is considered an error
- Use `dynamic_cast` to a pointer type when failure to find the 
  required class is considered a valid alternative
- Use `unique_ptr` or `shared_ptr` to avoid forgetting to
`delete` objects created using `new`
- Use `make_unique()` to construct objects owned by `unique_ptr`s
- Use `make_shared()` to construct objects owned by `shared_ptr`s
- Never assign a pointer to an array of derived class objects
to a pointer to its base
- Prefer virtual function to casting
### Overloading and overloaded operators
- Define operators primarily to mimic conventional usage
- Use non-member functions for symmetric operators
- Overload operations that are roughly equivalent
- Overload only for operations that are roughly equivalent
- Avoid implicit conversion operators
- Use `using` for customization points
- Overload unary `&` only as part of a system of smart
pointers and references
- Use an operator for an operation with its conventional meaning
- Define overloaded operators in the namespace of their operands
- If you feel like overloading a lambda, use a generic lambda
#### Unions
- Use `union`s to save memory
- Avoid "naked" `union`s
- Use anonymous `union`s to implement tagged unions
- Don't use a `union` for type punning

# Enum
- Prefer enumerations over macros
- Use enumerations to represent sets of related named constants
- Prefer class enums over "plain" enums
- Define operations on enumerations for safe and simple use
- Don't use `ALL_CAPS` for enumerators
- Avoid unnamed enumerations
- Specify the underlying type of an enumeration only when necessary
- Specify enumerator values only when necessary

# Resource management 
- Manage resources automatically using resource handles
and RAII(Resource Acquisition Is Initialization)
- In interfaces, use raw pointers to denote individual objects (only)
- A raw pointer (a `T*`) is non-owning
- A raw reference (a `T&`) is non-owning
- Prefer scoped objects, don't heap-allocate unnecessarily
- Avoid non-`const` global variables
## Allocation and deallocation
- Avoid `malloc()` and `free()`
- Avoid calling `new` and `delete` explicitly
- Immediately give the result of an explicit resource 
allocation to a manager object
- Perform at most one explicit resource allocation in a single
expression statement
- Avoid `[]` parameters, prefer `span`
- Always overload matched allocation/deallocation pairs
## Smart pointers
- Use `unique_prt` or `shared_ptr` to represent ownership
- Prefer `unique_ptr` over `shared_ptr` unless you need
to share ownership
- Use `make_shared()` to make `shared_ptr`s
- Use `make_unique()` to make `unique_ptr`s
- Use `std::weak_ptr` to break cycles of `shared_ptr`s
- Take smart pointers as parameters only to explicitly
express lifetime semantics
- If you have non-`std` smart pointers, follow the basic
pattern from `std`
- Take a `unique_ptr<widget>` parameter to express that
a function assumes ownership of a `widget`
- Take a `unique_ptr<widget>&` parameter to express that
a function reseats the `widget`
- Take a `shared_ptr<widget>` parameter to express shared ownership
- Take a `shared_ptr<widget>&` parameter to express that
a function might reseat the shared pointer
- Take a `const shared_ptr<widget>&` parameter to express
that it might retain a reference count to the object
- Do not pass a pointer or reference obtained from an aliased
smart pointer

# Expressions and statements
- Prefer the standard library to other libraries and 
to "handcrafted code"
- Prefer suitable abstractions to direct use of 
language features
- Don't repeat yourself, avoid redundant code
## Declarations
- Keep scopes small
- Declare names in for-statement initializers and
conditions to limit scope
- Keep common and local names short, and keep uncommon
and non-local names longer
- Avoid similar-looking names
- Avoid `ALL_CAPS` names
- Declare one name (only) per declaration
- Use `auto` to avoid redundant repetition of type names
- Do not reuse names in nested scopes
- Always initialize an object
- Don't introduce a variable (or constant) before
you need to use it
- Don't declare a variable until you have a value to
initialize it with
- Prefer the `{}`-initializer syntax
- Use a `unique_ptr<T>` to hold pointers
- Declare an object `const` or `constexpr` unless you 
want to modify its value later on
- Don't use a variable for two unrelated purposes
- Use `std::array` or `stack_array` for arrays on the stack
- Use lambdas for complex initialization, especially of 
`const` variables
- Don't use macros for program text manipulation
- Don't use macros for constants or "functions"
- Use `ALL_CAPS` for all macro names
- If you must use macros, give them unique names
- Don't define a (C-style) variadic function
## Expressions
- Avoid complicated expressions
- If in doubt about operator precedence, parenthesize
- Keep use of pointers simple and straightforward
- Avoid expressions with undefined order of evaluation
- Don't depend on order or evaluation of function arguments
- Avoid "magic constants"; use symbolic constants
- Avoid lossy(narrowing, truncating) arithmetic conversions
- Use `nullptr` rather than `0` or `NULL`
- Avoid casts
- If you must use a cast, use a named cast
- Don't cast away `const`
- Avoid the need for range checking
- Write `std::move()` only when you need to explicitly
move an object to another scope
- Avoid `new` and `delete` outside resource management
functions
- Delete arrays using `delete[]` and non-arrays using `delete`
- Don't compare pointers into different arrays
- Don't slice
- Use the `T{e}` notation for construction
- Don't dereference an invalid pointer
## Statements
- Prefer a `switch`-statement to an `if`-statement when 
there is a choice
- Prefer a range-for-statement to a `for`-statement when 
there is a choice
- Prefer a `for`-statement to a `while`-statement when
there is an obvious loop variable
- Prefer a `while`-statement to a `for`-statement when
there is no obvious loop variable
- Prefer to declare a loop variable in the initializer 
part of a `for-`statement
- Avoid `do`-statement
- Avoid `goto`
- Minimize the use of `bread` and `continue` in loops
- Don't rely on implicit fallthrough in `switch` statements
- Use `default` to handle common cases (only)
- Don't try to declare a local variable with no name
- Make empty statements visible
- Avoid modifying loop control variables inside the body
of raw for-loops
- Don't add redundant `==` or `!=` to conditions
## Arithmetic
- Don't mix signed and unsigned arithmetic
- Use unsigned types for bit manipulation
- Use signed types for arithmetic
- Don't overflow
- Don't underflow
- Don't divide by integer zero
- Don't try to avoid negative values by using `unsigned`
- Don't use `unsigned` for subscripts, prefer `gsl::index`


# Performance
- Don't optimize without reason
- Don't optimize prematurely
- Don't optimize something that's not performance critical
- Don't assume that complicated code is necessarily
faster than simple code
- Don't assume that low-level code is necessarily faster
than high-level code
- Don't make claims about performance without measurements
- Design to enable optimization
- Relay on the static type system
- Move computation from run time to compile time
- Eliminate redundant aliases
- Eliminate redundant indirections
- Minimize the number of allocations and deallocations
- Do not allocate on a critical branch
- Use compact data structures
- Declare the most used member of a time-critical struct first
- Space is time
- Access memory predictably
- Avoid context switches on the critical path

# Concurrency and parallelism
- Assume that your code will run as part of a multi-threaded program
- Avoid data races
- Minimize explicit sharing of writable data
- Think in terms of tasks, rather than threads
- Don't try to use `volatile` for synchronization
- Whenever feasible use tools to validate your concurrent code
## Concurrency
- Use RAII, never plain `lock()/unlock()`
- Use `std::lock()` or `std::scoped_lock` to acquire 
multiple `mutex`es
- Never call unknown code while holding a lock (e.g., a callback)
- Think of a joining `thread` as a scoped container
- Think of a `thread` as a global container
- Prefer `gsl::joining_thread` over `std::thread`
- Don't `detach()` a thread
- Pass small amounts of data between threads by value,
rather than by reference or pointer
- To share ownership between unrelated `thread`s use `shared_ptr`
- Minimize context switching
- Minimize thread creation and destruction
- Don't `wait` without a condition
- Minimize time spent in a critical section
- Remember to name you `lock_guard`s and `unique_lock`s
- Define a `mutex` together with the data it guards. Use
`synchronized_value<T>` where possible
  
## Coroutines
- Do not use capturing lambdas that are coroutines
- Do not hold locks or other synchronization primitives 
across suspension points
- Parameters to coroutines should not be passed by reference

## Parallelism
### Message passing
- Use a future to return a value from a concurrent task
- Use `async()` to spawn concurrent tasks

## Vectorization
## Lock-free programming
- Don't use lock-free programming unless you absolutely
have to
- Distrust your hardware/compiler combination
- Carefully study the literature
- Do not write your own double-checked locking for initialization
- Use a conventional pattern if you really need
double-checked locking

## Etc. concurrency rules
- Use `volatile` only to talk to non-C++ memory


# Error handling
- Develop an error-handling strategy early in a design
- Throw an exception to signal that a function can't perform
its assigned task
- Use exceptions for error handling only
- Design you error-handling strategy around invariants
- Let a constructor establish an invariant, and throw 
  if it cannot
- Use RAII to prevent leaks
- Sate your preconditions
- State your post-conditions
- Use `nonexcept` when exiting a function because of a
`throw` is impossible or unacceptable
- Never throw while being the direct owner of an object
- Use purpose-designed use-defined types as exceptions
  (not built-in types)
- Throw by value, catch exceptions from a hierarchy 
by reference
- Destructors, deallocation, and `swap` must never fail
- Dont' try to catch every exception in every function
- Minimize the use of explicit try/catch
- Use a `final_action` object to express cleanup if no
suitable resource handle is available
- If you can't throw exceptions, simulate RAII for 
resource management
- If you can't throw exceptions, consider failing fast
- If you can't throw exceptions, use error codes systematically
- Avoid error handling based on global state (e.g. `errno`)
- Don't use exception specifications
- Properly order you `catch`-clauses

# Constants and immutability
- By default, make objects immutable
- By default, make member functions `const`
- By default, pass pointers and reference to `const`s
- Use `const` to define objects with values that do not
change after construction
- Use `constexpr` for values that can be computed at compile time

#Templates and generic programming
## Generic programming
- Use templates to raise the level of abstraction of code
- Use templates to express algorithms that apply to many argument types
- Use templates to express containers and ranges
- Use templates to express syntax tree manipulation
- Combine generic and OO techniques to amplify their strengths, not
their costs
## Concept rules
### Concept use
- Specify concepts for all template arguments
- Whenever possible use standard concepts
- Prefer concept names over `auto` for local variables
- Prefer the shorthand notation for simple, single-type 
argument concepts
### Concept definition rules
- Avoid "concepts" without meaningful semantics
- Require a complete set of operations for a concept
- Specify axioms for concepts
- Differentiate a refined concept from its more general
case by adding new use patterns
- Use tag classes or traits to differentiate concepts that
differ only in semantics
- Avoid complementary constraints
- Prefer to define concepts in terms of use-patterns 
  rather than simple syntax

### Template interfaces
- Use function objects to pass operations to algorithms
- Require only essential properties in a template's concepts
- Use template aliases to simplify notation and hide
implementation details
- Prefer `using` over `typedef` for defining aliases
- Use function templates to deduce class template argument
types (where feasible)
- Require template arguments to be at least semi-regular
- Avoid highly visible unconstrained templates with common names
- If your compiler does not support concepts, fake them
with `enable_if`
- Where possible, avoid type-erasure

## Template definitions
- Minimize a template's context dependencies
- Do not over-parameterize members (SCARY)
- Place non-dependent class template members in a 
non-templated base class
- Use specialization to provide alternative implementations
of class templates
- Use tag dispatch to provide alternative implementations
of a function
- Use specialization to provide alternative implementations
for irregular types
- Use `{}` rather then `()` within templates to avoid ambiguities
- Inside a template, don't make an unqualified non-member
function call unless you intend it to be a customization point
## Template and hierarchy rules
- Do not naively templatize a class hierarchy
- Do not mix hierarchies and arrays
- Linearize a hierarchy when virtual functions are undesirable
- Do not declare a member function template virtual
- Use a non-template core implementation to provide an
ABI-stable interface 
## Variadic template rules
- Use variadic templates when you need a function takes a 
variable number of arguments of a variety of types
- How to pass arguments to variadic template
- How to process arguments to a variadic template
- Don't use variadic templates for homogeneous argument list
## Template metaprogramming
- Use template metaprogramming only when you really need to
- Use template metaprogramming primarily to emulate concepts
- Use templates (usually template aliases) to compute types
at compile time
- Use `constexpr` functions to compute values at compile time
- Prefer to use standard-library TMP facilities
- If you need go beyond the standard-library TMP facilities,
use an exiting library
## Other template rules
- Name all operations with potential for reuse
- Use an unnamed lambda if you need a simple function object
in one place only
- Use template variables to simplify notation
- Don't write unintentionally non-generic code
- Don't specialize function templates
- Check that a class matches a concept using `static_assert`

# C-style programming
- Prefer C++ to C
- If you must use C, use the common subset of C and C++ 
and compile the C doe as C++
- If you must use C for interfaces, use C++ in the calling
code using such interfaces

# Source files
- Use a `.cpp` suffix for code files and `.h` for interface
files if your project doesn't already follow another convention
- A `.h` file must not contain object definitions or non-inline 
function definitions
- Use `.h` files for all declarations used in multiple source
files
- Include `.h` files before other declarations in a file
- A `.cpp` file must include the `.h` file(s) that defines 
its interface
- Use `using namespace` directives for transition, for foundation
libraries (such as `std`), or within a local scope (only)
- Don't write `using namespace` at global scope in a header file
- Use `#include` guards for all `.h` files
- Avoid cyclic dependencies among source files
- Avoid dependencies on implicitly `#include`d names
- Header files should be self-contained
- Prefer the quote form of `#include` for files relative to the
including file and the angle bracket form everywhere else
- Use `namespace`s to express logical structure
- Don't use an unnamed (anonymous) namespace in a header
- Use an unnamed(anonymous) namespace for all internal/non 
exported entities

# The Standard Library
- Use libraries wherever possible
- Prefer the standard library to other libraries
- Do not add non-standard entities to namespace `std`
- Use the standard library in a type-safe manner
## Containers
- Prefer using STL `array` or `vector` instead of a C array
- Prefer using STL `vector` by default unless you have a 
reason to use a different container
- Avoid bounds errors
- don't use `memset` or `memcpy` for arguments that are
not trivially-copyable
## String
- Use `std::string` to own character sequences
- Use `std::string_view` or `gsl::span<char>` to refer
to character sequences
- Use `zstring` or `czstring` to refer to C-style, 
zero-terminated, sequence of characters
- Use `char*` to refer to a single character
- Use `std::byte` to refer to byte values that do not 
necessarily represent characters
- Use `std::string` when you need to perform locale-sensitive
string operations
- Use `gsl::span<char>` rather than `std::string_view` when
you need to mutate a string
- Use the `s` suffix for string literals meant to be 
standard-library `string`s


  