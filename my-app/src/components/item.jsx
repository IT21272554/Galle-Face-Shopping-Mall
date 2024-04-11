import axios from 'axios';
import { useEffect, useState } from "react";
 
function Item() {
  // Logic
  const [itemid, setId] = useState('');
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [category, setCategory] = useState("");
  const [items, setItems] = useState([]);
  const [errorMessage, setErrorMessage] = useState("");

  useEffect(() => {
    (async () => await loadItems())();
  }, []);

  async function loadItems() {
    try {
      const result = await axios.get("http://localhost:8090/item/getAll");
      setItems(result.data);
      console.log(result.data);
    } catch (error) {
      console.error("Failed to load items:", error);
    }
  }

  async function save(event) {
    event.preventDefault();

    if (!name || !category || !description) {
      setErrorMessage("Please fill out all fields.");
      return;
    }

    try {
      await axios.post("http://localhost:8090/item/save", {
        name: name,
        description: description,
        category: category
      });
      alert("Item Created Successfully");
      setId("");
      setName("");
      setDescription("");
      setCategory("");
      setErrorMessage("");
      loadItems();
    } catch (err) {
      alert("Item Creation Failed");
    }
  }

  async function editItem(item) {
    setName(item.name);
    setDescription(item.description);
    setCategory(item.category);
    setId(item._id);
  }

  async function deleteItem(itemId) {
    try {
      await axios.delete("http://localhost:8090/item/delete/" + itemId);
      alert("Item Deleted Successfully");
      loadItems();
    } catch (err) {
      alert("Failed to delete item");
    }
  }

  async function update(event) {
    event.preventDefault();

    if (!name || !category || !description) {
      setErrorMessage("Please fill out all fields.");
      return;
    }

    try {
      await axios.put("http://localhost:8090/item/edit/" + itemid, {
        name: name,
        description: description,
        category: category
      });
      alert("Item Updated Successfully");
      setId("");
      setName("");
      setDescription("");
      setCategory("");
      setErrorMessage("");
      loadItems();
    } catch (err) {
      alert("Failed to update item");
    }
  }

  // Design
  return (
    <div>
      <h1>Items Details</h1>
      <div className="container mt-4">
        <form>
          <div className="form-group">
            <label>Item Name</label>
            <input
              type="text"
              className="form-control"
              value={name}
              onChange={(event) => setName(event.target.value)}
            />
          </div>

          <div className="form-group">
            <label>Item Description</label>
            <input
              type="text"
              className="form-control"
              value={description}
              onChange={(event) => setDescription(event.target.value)}
            />
          </div>

          <div className="form-group">
            <label>Item Category</label>
            <input
              type="text"
              className="form-control"
              value={category}
              onChange={(event) => setCategory(event.target.value)}
            />
          </div>


          <div>
            <button className="btn btn-primary mt-4" onClick={save}>
              Create
            </button>

            <button className="btn btn-warning mt-4" onClick={update}>
              Update
            </button>
          </div>
        </form>
      </div>
      <br />
      {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}
      <table className="table table-dark" align="center">
        <thead>
          <tr>
            <th scope="col">Item Name</th>
            <th scope="col">Item Description</th>
            <th scope="col">Item Category</th>
            <th scope="col">Option</th>
          </tr>
        </thead>
        <tbody>
          {items.map((item) => (
            <tr key={item._id}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>{item.category}</td>
              <td>
                <button
                  type="button"
                  className="btn btn-warning"
                  onClick={() => editItem(item)}
                >
                  Edit
                </button>
                <button
                  type="button"
                  className="btn btn-danger"
                  onClick={() => deleteItem(item._id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Item;
