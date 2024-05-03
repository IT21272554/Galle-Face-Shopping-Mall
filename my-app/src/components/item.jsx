import axios from 'axios';
import { useEffect, useState } from "react";
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

function Item() {
    // Logic
    const [itemid, setId] = useState('');
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [category, setCategory] = useState("");
    const [shopId, setShopId] = useState("");
    const [price, setPrice] = useState(0);
    const [quantity, setQuantity] = useState(0);
    const [thumbnail, setThumbnail] = useState(["", "", "", ""]);
    const [items, setItems] = useState([]);

    useEffect(() => {
        Load();
    }, []);

    async function Load() {
        try {
            const result = await axios.get("http://localhost:8090/item/getAll");
            setItems(result.data);
        } catch (err) {
            console.error("Error loading items:", err);
        }
    }

    async function save(event) {
        event.preventDefault();
        try {
            await axios.post("http://localhost:8090/item/save", {
                name: name,
                description: description,
                category: category,
                shopId: shopId,
                price: price,
                quantity: quantity,
                thumbnail: thumbnail
            });
            alert("Item created successfully");
            clearFields();
            Load();
        } catch (err) {
            alert("Item creation failed");
        }
    }

    async function editItem(item) {
        setName(item.name);
        setDescription(item.description);
        setCategory(item.category);
        setShopId(item.shopId);
        setId(item._id);
        setPrice(item.price);
        setQuantity(item.quantity);
        setThumbnail(item.thumbnail);
    }

    async function DeleteItem(itemId) {
        try {
            await axios.delete("http://localhost:8090/item/delete/" + itemId);
            alert("Item deleted successfully");
            Load();
        } catch (err) {
            alert("Item deletion failed");
        }
    }

    async function update(event) {
        event.preventDefault();
        try {
            await axios.put("http://localhost:8090/item/edit/" + itemid, {
                name: name,
                description: description,
                category: category,
                shopId: shopId,
                price: price,
                quantity: quantity,
                thumbnail: thumbnail
            });
            alert("Item updated successfully");
            clearFields();
            Load();
        } catch (err) {
            alert("Item update failed");
        }
    }

    function clearFields() {
        setId("");
        setName("");
        setDescription("");
        setCategory("");
        setShopId("");
        setPrice(0);
        setQuantity(0);
        setThumbnail(["", "", "", ""]);
    }

    async function downloadReport() {
      const doc = new jsPDF();
  
      const table = document.getElementById('tableToExport');
      const tableWidth = table.offsetWidth;
      const tableHeight = table.offsetHeight;
  
      await html2canvas(table, { 
          width: tableWidth, 
          height: tableHeight, 
          scrollY: -window.scrollY 
      }).then(canvas => {
          const imgData = canvas.toDataURL('image/png');
          const imgWidth = 230; // A4 size
          const imgHeight = (canvas.height * imgWidth) / canvas.width;
          doc.addImage(imgData, 'PNG', 10, 10, imgWidth, imgHeight);
      });
  
      doc.save('items_report.pdf');
  }

    // Design
    return (
        <div>
            <br />
            <h1>Items Details</h1>
            <div className="container mt-4">
                <form>
                    {/* Form inputs */}
                    <div className="form-group">
                        <label>Item Name</label>
                        <input type="text" className="form-control" id="name"
                               value={name}
                               onChange={(event) => {
                                   setName(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Item Description</label>
                        <input type="text" className="form-control" id="description"
                               value={description}
                               onChange={(event) => {
                                   setDescription(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Item Category</label>
                        <select className="form-control" id="category"
                               value={category}
                               onChange={(event) => {
                                   setCategory(event.target.value);
                               }}
                        >
                            <option value="">Select category...</option>
                            <option value="Electronics & Technology">Electronics & Technology</option>
                            <option value="Apparel & Fashion">Apparel & Fashion</option>
                            <option value="Food & Beverage">Food & Beverage</option>
                            <option value="Home & Decor">Home & Decor</option>
                            <option value="Health & Beauty">Health & Beauty</option>
                            <option value="Entertainment">Entertainment</option>
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Item ShopId</label>
                        <input type="text" className="form-control" id="shopId"
                               value={shopId}
                               onChange={(event) => {
                                   setShopId(event.target.value);
                               }}
                        />
                    </div>

                    {/* Additional Inputs */}
                    <div className="form-group">
                        <label>Price</label>
                        <input type="number" className="form-control" value={price}
                               onChange={(event) => {
                                   setPrice(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Quantity</label>
                        <input type="number" className="form-control" value={quantity}
                               onChange={(event) => {
                                   setQuantity(event.target.value);
                               }}
                        />
                    </div>

                    {/* Thumbnail */}
                    <div className="form-group">
                        <label>Thumbnail</label>
                        <input type="text" className="form-control" value={thumbnail[0]}
                               onChange={(event) => {
                                   let newThumbnail = [...thumbnail];
                                   newThumbnail[0] = event.target.value;
                                   setThumbnail(newThumbnail);
                               }}
                        />
                    </div>

                    <div>
                        <button className="btn btn-primary mt-4" onClick={save}>Create</button>
                        <button className="btn btn-warning mt-4" onClick={update}>Update</button>
                    </div>
                </form>
            </div>

            <br />

            {/* Table */}
            <table id="tableToExport" className="table table-dark" align="center">
                <thead>
                    <tr>
                        <th scope="col">Item Name</th>
                        <th scope="col">Item Description</th>
                        <th scope="col">Item Category</th>
                        <th scope="col">Item ShopId</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Thumbnail</th>
                        <th scope="col">Option</th>
                    </tr>
                </thead>
                <tbody>
                    {items.map(item => (
                        <tr key={item._id}>
                            <td>{item.name}</td>
                            <td>{item.description}</td>
                            <td>{item.category}</td>
                            <td>{item.shopId}</td>
                            <td>{item.price}</td>
                            <td>{item.quantity}</td>
                            <td>{item.thumbnail.join(',')}</td>
                            <td>
                                <button type="button" className="btn btn-warning" onClick={() => editItem(item)}>Edit</button>
                                <button type="button" className="btn btn-danger" onClick={() => DeleteItem(item._id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

            {/* Download Report Button */}
            <div className="text-center">
                <button className="btn btn-success mt-4" onClick={downloadReport}>Download Report</button>
            </div>
            <br />
        </div>
    );
}

export default Item;
