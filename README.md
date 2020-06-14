Spring Events
--

This project is demonstrating the usage:
1. Sync Events (User Sign-up)
    1. Multiple Event
    1. Conditional Events
    1. Generic Events
1. Async Events (Stock Update)
1. Transactional Events (Order placed)

_Important Points_
1. By default spring events are synchronous. It can be made as asynchronous. 
1. Implement Event handling thorough annotations
1. Event listener can be made conditional by using SpEL but they are not ordered in case multiple listeners are listening to same event. Also there is issue if same property is used in condition in more than one listener, one of the listener will be invoked.
1. Listener can listen to multiple events, by defining events in annotation (can be used for single event). Actual event can be captured by defining generic Object as parameter.
1. If Event Listener returns any non-null value, it will be another event published. Multiple events can be emitted by returning a collection.
1. Take special care, when your event is of generic type, in that case your event need to extend generic event of specific type while publishing event
1. Transaction Events listeners can be bound to different phases of transaction
1. Multiple events can be fired from an event publisher (if transactional, it will be fired at end of transaction)


In case Of DB Transaction and event published before saving entity, following may happen with entity state:

|Listener Type|@Sync|@Async|
|-------------|------|--------|
|@EventListener|Transient|Indeterminant|
|@TransactionEventListener|Managed & Persisted|Detached & Persisted|

Event Handling Approach in different bounded context
* Publish message on transaction commit (using @TransactionalEventListener)
* Use async mechanism like queue to separate bounded context
* But instead of directly adding in queue, persist event in DB aka Event Store
* Scheduled job to send event to async queue and update status of DB as SENT
* Consumer to avoid duplicate message, if message sent more than once

_References_
* https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-eventlistener.html
* https://www.baeldung.com/spring-events
* https://blog.codeleak.pl/2017/10/asynchrouns-and-transactional-event.html
* http://pillopl.github.io/reliable-domain-events/