let orders = [];

let addOrder = function (menu, quantity) {
  orders.push({ menu: menu, quantity: quantity });
};

export { orders, addOrder };
