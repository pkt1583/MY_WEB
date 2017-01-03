package com.project.service;

import com.project.dao.ShoppingCartDao;
import com.project.domain.Inventory;
import com.project.domain.OrderLineItem;
import com.project.domain.Product;
import com.project.domain.ShoppingCart;
import com.project.exception.InsufficientQuatityException;
import com.project.exception.ShoppingCartUpdateFailedException;

import javax.ejb.Stateful;
import javax.inject.Inject;
import java.util.Set;

@Stateful
public class ShoppingCartService {
    private ShoppingCart cart = new ShoppingCart();

    @Inject
    private InventoryService inventoryService;

    @Inject
    private OrderService orderService;

    @Inject
    private ShoppingCartDao shoppingCartDao;

    public ShoppingCart getShoppingCart(Integer shoppingCartId) {
        return new ShoppingCart();
    }

    public ShoppingCart addProduct(Product product, Integer quantity) throws InsufficientQuatityException {
        Inventory inventory = checkQuantityInInventory(product, quantity);
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setProduct(product);
        orderLineItem.setQuantity(quantity);
        cart.addOrderLineItem(orderLineItem);
        return cart;
    }

    private Inventory checkQuantityInInventory(Product product, Integer quantity) throws InsufficientQuatityException {
        Inventory inventory = inventoryService.getProductInventoryDetails(product);
        if (inventory.getCurrentStock() <= quantity) {
            inventoryService.updateProduct(product,inventory, quantity);
        } else {
            throw new InsufficientQuatityException("Not enought stock");
        }
       return new Inventory();
    }

    public boolean checkout(ShoppingCart shoppingCart) {
        orderService.createOrder(cart);
        return true;
    }

    public ShoppingCart updateProduct(Product product, Integer quantity) throws InsufficientQuatityException, ShoppingCartUpdateFailedException {
        if(quantity==0){
            cart.getOrderLineItems().remove(product);
            if(!shoppingCartDao.updateCart(cart)){
                throw new ShoppingCartUpdateFailedException("Failed to update shopping cart");
            }
        }else {
            Set<OrderLineItem> orderLineItems = cart.getOrderLineItems();
            for (OrderLineItem orderLineItem : orderLineItems) {
                Product lineItemProduct = orderLineItem.getProduct();
                if (lineItemProduct.equals(product)) {
                    inventoryService.updateProduct(product, checkQuantityInInventory(product, quantity), quantity);
                    orderLineItem.setQuantity(quantity);
                }
            }
        }
        return cart;
    }

}
