import axios from 'axios';
import { useEffect, useState } from "react";
import jsPDF from 'jspdf';
import html2canvas from 'html2canvas';

function Shop() {
    // Logic
    const [shopId, setShopId] = useState('');
    const [name, setName] = useState("");
    const [logoImage, setLogoImage] = useState("");
    const [description, setDescription] = useState("");
    const [category, setCategory] = useState("");
    const [ownerName, setOwnerName] = useState("");
    const [contactNumber, setContactNumber] = useState("");
    const [email, setEmail] = useState("");
    const [floorNumber, setFloorNumber] = useState(0);
    const [openingTime, setOpeningTime] = useState("");
    const [closingTime, setClosingTime] = useState("");
    const [shops, setShops] = useState([]);
    const [validationError, setValidationError] = useState("");

    useEffect(() => {
        Load();
    }, []);

    async function Load() {
        try {
            const result = await axios.get("http://localhost:8090/shop/getAll");
            setShops(result.data);
        } catch (err) {
            console.error("Error loading shops:", err);
        }
    }

    async function save(event) {
        event.preventDefault();
        if (!validateInputs()) {
            return;
        }
        try {
            await axios.post("http://localhost:8090/shop/save", {
                name: name,
                description: description,
                category: category,
                ownerName: ownerName,
                contactNumber: contactNumber,
                email: email,
                floorNumber: floorNumber,
                openingTime: openingTime,
                closingTime: closingTime,
                logoImage: logoImage
            });
            alert("Shop created successfully");
            clearFields();
            Load();
        } catch (err) {
            alert("Shop creation failed");
        }
    }

    async function editShop(shop) {
        setName(shop.name);
        setDescription(shop.description);
        setCategory(shop.category);
        setOwnerName(shop.ownerName);
        setContactNumber(shop.contactNumber);
        setEmail(shop.email);
        setFloorNumber(shop.floorNumber);
        setOpeningTime(shop.openingTime);
        setClosingTime(shop.closingTime);
        setLogoImage(shop.logoImage);
        setShopId(shop._id);
    }

    async function DeleteShop(shopId) {
        try {
            await axios.delete("http://localhost:8090/shop/delete/" + shopId);
            alert("Shop deleted successfully");
            Load();
        } catch (err) {
            alert("Shop deletion failed");
        }
    }

    async function update(event) {
        event.preventDefault();
        if (!validateInputs()) {
            return;
        }
        try {
            await axios.put("http://localhost:8090/shop/edit/" + shopId, {
                name: name,
                description: description,
                category: category,
                ownerName: ownerName,
                contactNumber: contactNumber,
                email: email,
                floorNumber: floorNumber,
                openingTime: openingTime,
                closingTime: closingTime,
                logoImage: logoImage
            });
            alert("Shop updated successfully");
            clearFields();
            Load();
        } catch (err) {
            alert("Shop update failed");
        }
    }

    function clearFields() {
        setShopId("");
        setName("");
        setDescription("");
        setCategory("");
        setOwnerName("");
        setContactNumber("");
        setEmail("");
        setFloorNumber(0);
        setOpeningTime("");
        setClosingTime("");
        setLogoImage("");
        setValidationError("");
    }

    function validateInputs() {
        if (!name || !description || !category || !ownerName || !contactNumber || !email || !openingTime || !closingTime) {
            setValidationError("All fields are required");
            return false;
        }

        if (!/^\d{10}$/.test(contactNumber)) {
            setValidationError("Contact Number should be 10 digits");
            return false;
        }

        if (!/\S+@\S+\.\S+/.test(email)) {
            setValidationError("Invalid email address");
            return false;
        }

        if (!/^([01]\d|2[0-3]):([0-5]\d)$/.test(openingTime)) {
            setValidationError("Opening Time should be in HH:MM format (24-hour clock)");
            return false;
        }

        if (!/^([01]\d|2[0-3]):([0-5]\d)$/.test(closingTime)) {
            setValidationError("Closing Time should be in HH:MM format (24-hour clock)");
            return false;
        }

        return true;
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
            const imgWidth = 215; // A4 size
            const imgHeight = (canvas.height * imgWidth) / canvas.width;
            doc.addImage(imgData, 'PNG', 10, 10, imgWidth, imgHeight);
        });

        doc.save('shops_report.pdf');
    }

    // Design
    return (
        <div>
            <br />
            <h1>Shops Details</h1>
            <div className="container mt-4">
                <form>
                    {/* Form inputs */}
                    <div className="form-group">
                        <label>Shop Name</label>
                        <input type="text" className="form-control" id="name"
                               value={name}
                               onChange={(event) => {
                                   setName(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Description</label>
                        <input type="text" className="form-control" id="description"
                               value={description}
                               onChange={(event) => {
                                   setDescription(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Category</label>
                        <select className="form-control" id="category"
                               value={category}
                               onChange={(event) => {
                                   setCategory(event.target.value);
                               }}
                        >
                            <option value="">Select Category</option>
                            <option value="Apparel & Fashion">Apparel & Fashion</option>
                            <option value="Electronics & Technology">Electronics & Technology</option>
                            <option value="Home & Decor">Home & Decor</option>
                            <option value="Health & Beauty">Health & Beauty</option>
                            <option value="Food & Beverage">Food & Beverage</option>
                            <option value="Entertainment">Entertainment</option>
                            <option value="Services">Services</option>
                            <option value="Specialty Stores">Specialty Stores</option>
                        </select>
                    </div>

                    <div className="form-group">
                        <label>Owner Name</label>
                        <input type="text" className="form-control" id="ownerName"
                               value={ownerName}
                               onChange={(event) => {
                                   setOwnerName(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Contact Number</label>
                        <input type="text" className="form-control" id="contactNumber"
                               value={contactNumber}
                               onChange={(event) => {
                                   const input = event.target.value.replace(/\D/, ''); // Remove non-numeric characters
                                   setContactNumber(input);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Email</label>
                        <input type="email" className="form-control" id="email"
                               value={email}
                               onChange={(event) => {
                                   setEmail(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Floor Number</label>
                        <input type="number" className="form-control" id="floorNumber"
                               value={floorNumber}
                               onChange={(event) => {
                                   setFloorNumber(parseInt(event.target.value));
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Opening Time</label>
                        <input type="text" className="form-control" id="openingTime"
                               value={openingTime}
                               onChange={(event) => {
                                   setOpeningTime(event.target.value);
                               }}
                        />
                    </div>

                    <div className="form-group">
                        <label>Closing Time</label>
                        <input type="text" className="form-control" id="closingTime"
                               value={closingTime}
                               onChange={(event) => {
                                   setClosingTime(event.target.value);
                               }}
                        />
                    </div>

                    {validationError && <div className="alert alert-danger">{validationError}</div>}

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
                        <th scope="col">Shop ID</th>
                        <th scope="col">Shop Name</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Name</th>
                        <th scope="col">Contact Number</th>
                        <th scope="col">Email</th>
                        <th scope="col">Floor Number</th>
                        <th scope="col">Opening Time</th>
                        <th scope="col">Closing Time</th>
                        <th scope="col">Option</th>
                    </tr>
                </thead>
                <tbody>
                    {shops.map(shop => (
                        <tr key={shop._id}>
                            <td>{shop._id}</td>
                            <td>{shop.name}</td>
                            <td>{shop.description}</td>
                            <td>{shop.category}</td>
                            <td>{shop.ownerName}</td>
                            <td>{shop.contactNumber}</td>
                            <td>{shop.email}</td>
                            <td>{shop.floorNumber}</td>
                            <td>{shop.openingTime}</td>
                            <td>{shop.closingTime}</td>
                            <td>
                                <button type="button" className="btn btn-warning" onClick={() => editShop(shop)}>Edit</button>
                                <button type="button" className="btn btn-danger" onClick={() => DeleteShop(shop._id)}>Delete</button>
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

export default Shop;
