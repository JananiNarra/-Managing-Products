import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {

  const [products, setProducts] = useState([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");

  const API = "http://localhost:8081/api/products";

  

  useEffect(() => {
    load();
  }, []);

  const load = () => {
    axios.get(API).then(res => setProducts(res.data));
  };

  const addProduct = () => {
  axios.post(API, { 
    name, 
    price: Number(price)   // ✅ IMPORTANT FIX
  }).then(load);
};

  const addToCart = (id) => {
    axios.put(`${API}/cart/${id}`).then(load);
  };

  const deleteProduct = (id) => {
    axios.delete(`${API}/${id}`)
      .then(load)
      .catch(err => alert(err.response.data.message));
  };

  return (
  <div className="container">
    <h1 className="title">🛒 Easy Basket</h1>

    <div className="form">
      <input
        className="input"
        placeholder="Laptop Name"
        onChange={e => setName(e.target.value)}
      />
      <input
        className="input"
        placeholder="Price"
        onChange={e => setPrice(e.target.value)}
      />
      <button className="addBtn" onClick={addProduct}>
        Add Product
      </button>
    </div>
    <div className="navbar">
  <div className="logo">🛒 Easy Basket</div>

  <div className="navLinks">
    <span>Home</span>
    <span>Products</span>
    <span className="cartCount">
      Cart ({products.filter(p => p.inCart).length})
    </span>
  </div>
</div>

    <div className="productList">
      {products.map(p => (
        <div className="card" key={p.id}>
          <div className="cardContent">
            <h3>{p.name}</h3>
            <p>₹{p.price}</p>
          </div>

          <div className="actions">
            <button
              className="cartBtn"
              onClick={() => addToCart(p.id)}
            >
              Add to Cart
            </button>

            {p.inCart && (
              <button
                className="deleteBtn"
                onClick={() => deleteProduct(p.id)}
              >
                Delete
              </button>
            )}
          </div>
        </div>
      ))}
    </div>
  </div>
  );
}

export default App;