package com.amit.events.db.order.listener;

import com.amit.events.db.order.entity.Order;
import com.amit.events.db.order.event.OrderEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Component
public class OrderEventListener {

    @Resource
    private EntityManager entityManager;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforePlacingOrder(OrderEvent event){
        event.getOrder().setHasGoodiesAdded(true);
        System.out.println(Thread.currentThread().getName() + ": Before commiting adding Goodies in order. Order Entity status : Detached - " + isDetached(event.getOrder()) + " : Transient - " + isTransient(event.getOrder()) + " : Managed - " + isManaged(event.getOrder()));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterPlacingOrder(OrderEvent event){
        System.out.println(Thread.currentThread().getName() + ": After commit Order Event (Sync) " + event + ". Notifying user about success. Order Entity status : Detached - " + isDetached(event.getOrder()) + " : Transient - " + isTransient(event.getOrder()) + " : Managed - " + isManaged(event.getOrder()));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterFailingOrder(OrderEvent event){
        System.out.println(Thread.currentThread().getName() + ": After rollback Order Event (Sync) " + event + ". Notifying user about failure");
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforePlacingOrderAsync(OrderEvent event){
        System.out.println(Thread.currentThread().getName() + ": (ASYNC) Before commiting adding Goodies in order. Order Entity status : Detached - " + isDetached(event.getOrder()) + " : Transient - " + isTransient(event.getOrder()) + " : Managed - " + isManaged(event.getOrder()));
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterPlacingOrderAsync(OrderEvent event){
        System.out.println(Thread.currentThread().getName() + ": After commit Order Event (Async) " + event + ". Notifying user about success (Async). Order Entity status : Detached - " + isDetached(event.getOrder()) + " : Transient - " + isTransient(event.getOrder()) + " : Managed - " + isManaged(event.getOrder()));
    }

    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void afterFailingOrderAsync(OrderEvent event){
        System.out.println(Thread.currentThread().getName() + ": After rollback Order Event (Async) " + event + ". Notifying user about failure (Async). Order Entity status : Detached - " + isDetached(event.getOrder()) + " : Transient - " + isTransient(event.getOrder()) + " : Managed - " + isManaged(event.getOrder()));
    }

    private boolean isTransient(Order order) {
        return order.getId() == null;
    }

    private boolean isManaged(Order order) {
        return entityManager.contains(order);
    }

    private boolean isDetached(Order order) {
        return !isTransient(order)
                && !isManaged(order)
                && exists(order);
    }

    private boolean exists(Order order) {
        return entityManager.find(Order.class, order.getId()) != null;
    }
}
