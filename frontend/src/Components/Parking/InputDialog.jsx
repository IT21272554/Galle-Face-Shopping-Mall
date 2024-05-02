import {
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  MenuItem,
  TextField,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import { API_URL } from "../../constants/urls";
import axios from "axios";
import Swal from "sweetalert2";

const InputDialog = ({
  open,
  handleClose,
  selectedSlot,
  slots,
  setSlots,
  setBookedSlots,
  setAvailableSlots,
}) => {
  const [slotNumber, setSlotNumber] = useState(null);
  const [name, setName] = useState("");
  const [nic, setNic] = useState("");
  const [vehicleNumber, setVehicleNumber] = useState("");
  const [vehicleType, setVehicleType] = useState();
  const [date, setDate] = useState("");
  const [checkInTime, setCheckInTime] = useState("");
  const [checkOutTime, setCheckOutTime] = useState("");
  const [payment, setPayment] = useState(0);

  const [loading, setLoading] = useState(false);

  const calculatePayment = (date, inTime) => {
    const costPerHour = 500;

    const checkIn = new Date(`${date} ${inTime}`);
    const checkOut = new Date();
    const difference = checkOut - checkIn;
    const hours = Math.ceil(difference / 1000 / 60 / 60);
    const payment = Math.max(1, hours) * costPerHour;

    console.log("payment: ", payment);
    return payment;
  };

  const handleCheckIn = () => {
    if (!name || !nic || !vehicleNumber || !vehicleType) {
      handleClose();
      Swal.fire({
        title: "Missing Information",
        text: "Please fill in all the fields.",
        icon: "warning",
      });
      return;
    }
    const newSlotHistory = {
      slotNumber: selectedSlot.slotNumber,
      name,
      nic,
      vehicleNumber,
      vehicleType: vehicleType,
      date: new Date().toLocaleDateString(),
      checkInTime: new Date().toLocaleTimeString(),
      checkOutTime,
      payment,
    };

    axios
      .post(`${API_URL}/slotHistory`, newSlotHistory)
      .then((response) => {
        const { _id } = response.data;
        // Find the index of the selected slot in the slots array
        const slotIndex = slots.findIndex(
          (slot) => slot.slotNumber === selectedSlot.slotNumber
        );

        // Make a copy of the slots array
        const newSlots = [...slots];

        // Update the isBooked and vehicleType properties of the selected slot
        newSlots[slotIndex] = {
          ...newSlots[slotIndex],
          isBooked: true,
          vehicleType: vehicleType,
          historyId: _id,
        };

        // Update the slot in the backend
        axios
          .put(`${API_URL}/slot/update`, newSlots[slotIndex])
          .then((response) => {
            // Update the slots state
            setSlots(newSlots);
          })
          .catch((error) => console.error("Error:", error));

        // Clear all the input fields
        setSlotNumber(null);
        setName("");
        setNic("");
        setVehicleNumber("");
        setVehicleType();
        setDate("");
        setCheckInTime("");
        setCheckOutTime("");
        setPayment("");

        setBookedSlots((prevCount) => prevCount + 1);
        setAvailableSlots((prevCount) => prevCount - 1);
      })
      .catch((error) => console.error("Error:", error));

    handleClose();
  };

  useEffect(() => {
    if (open && selectedSlot.isBooked) {
      setLoading(true);
      axios
        .get(`${API_URL}/slotHistory/${selectedSlot.historyId}`)
        .then((response) => {
          setName(response.data.name);
          setNic(response.data.nic);
          setVehicleNumber(response.data.vehicleNumber);
          setVehicleType(response.data.vehicleType);
          setDate(response.data.date);
          setCheckInTime(response.data.checkInTime);
          setPayment(
            calculatePayment(response.data.date, response.data.checkInTime)
          );
          setLoading(false);
        })
        .catch((error) => {
          console.error("Error:", error);
          setLoading(false);
        });
    }
  }, [open]);

  const handleCheckOut = () => {
    const updatedSlotHistory = {
      slotNumber: selectedSlot.slotNumber,
      name,
      nic,
      vehicleNumber,
      vehicleType: vehicleType,
      date,
      checkInTime,
      checkOutTime: new Date().toLocaleTimeString(),
      payment,
    };

    axios
      .put(
        `${API_URL}/slotHistory/${selectedSlot.historyId}`,
        updatedSlotHistory
      )
      .then((response) => {
        console.log(response.data);

        // Find the index of the selected slot in the slots array
        const slotIndex = slots.findIndex(
          (slot) => slot.slotNumber === selectedSlot.slotNumber
        );

        // Make a copy of the slots array
        const newSlots = [...slots];

        // Update the isBooked and vehicleType properties of the selected slot
        newSlots[slotIndex] = {
          ...newSlots[slotIndex],
          isBooked: false,
          vehicleType: "",
          historyId: "",
        };

        // Update the slot in the backend
        axios
          .put(`${API_URL}/slot/update`, newSlots[slotIndex])
          .then((response) => {
            // Update the slots state
            setSlots(newSlots);
          })
          .catch((error) => console.error("Error:", error));

        setBookedSlots((prevCount) => prevCount - 1);
        setAvailableSlots((prevCount) => prevCount + 1);
      })
      .catch((error) => {
        console.error("Error:", error);
      });

    // Clear all the fields
    setName("");
    setNic("");
    setVehicleNumber("");
    setVehicleType("");
    setDate("");
    setCheckInTime("");
    setCheckOutTime("");
    setPayment("");

    handleClose();
  };

  return (
    <Dialog
      open={open}
      onClose={handleClose}
      PaperProps={{
        style: {
          backgroundColor: "rgba(228,237,255,255)",
          borderRadius: "10px",
          width: "50%",
        },
      }}
    >
      <DialogTitle>
        Enter Details for Slot {selectedSlot.slotNumber}
      </DialogTitle>
      <DialogContent
        sx={{
          display: "flex",
          flexDirection: "column",
          rowGap: "10px",
        }}
      >
        <TextField
          autoFocus
          margin="dense"
          id="name"
          label="Name"
          type="text"
          fullWidth
          value={name}
          onChange={(e) => setName(e.target.value)}
          sx={{
            bgcolor: "white",
            borderRadius: "10px",
          }}
          InputProps={{
            style: {
              borderRadius: "10px",
            },
          }}
        />
        <TextField
          margin="dense"
          id="nic"
          label="NIC"
          type="text"
          fullWidth
          value={nic}
          onChange={(e) => setNic(e.target.value)}
          sx={{
            bgcolor: "white",
            borderRadius: "10px",
          }}
          InputProps={{
            style: {
              borderRadius: "10px",
            },
          }}
        />
        <TextField
          margin="dense"
          id="vehicleNumber"
          label="Vehicle Number"
          type="text"
          fullWidth
          value={vehicleNumber}
          onChange={(e) => setVehicleNumber(e.target.value)}
          sx={{
            bgcolor: "white",
            borderRadius: "10px",
          }}
          InputProps={{
            style: {
              borderRadius: "10px",
            },
          }}
        />
        {!loading && (
          <TextField
            select
            margin="dense"
            id="vehicleType"
            label="Vehicle Type"
            fullWidth
            value={vehicleType}
            onChange={(e) => {
              setVehicleType(e.target.value);
            }}
            sx={{
              bgcolor: "white",
              borderRadius: "10px",
            }}
            InputProps={{
              style: {
                borderRadius: "10px",
              },
            }}
          >
            <MenuItem value="Car">Car</MenuItem>
            <MenuItem value="Van">Van</MenuItem>
            <MenuItem value="Bike">Bike</MenuItem>
            <MenuItem value="Three Wheeler">Three Wheeler</MenuItem>
          </TextField>
        )}
        {selectedSlot.isBooked && (
          <TextField
            margin="dense"
            id="payment"
            label="Payment"
            type="number"
            fullWidth
            value={payment}
            onChange={(e) => setPayment(e.target.value)}
            sx={{
              bgcolor: "white",
              borderRadius: "10px",
            }}
            InputProps={{
              style: {
                borderRadius: "10px",
              },
            }}
          />
        )}
      </DialogContent>
      <DialogActions sx={{ mb: "10px", mr: "18px" }}>
        <Button
          variant="contained"
          disableElevation
          disabled={!selectedSlot.isBooked}
          onClick={handleCheckOut}
          sx={{
            bgcolor: "rgba(0, 0, 255, 0.5)",
            borderRadius: "10px",
            textTransform: "none",
          }}
        >
          Check Out
        </Button>
        <Button
          onClick={handleCheckIn}
          disabled={selectedSlot.isBooked}
          variant="contained"
          disableElevation
          sx={{
            bgcolor: "rgba(0, 0, 255, 0.5)",
            borderRadius: "10px",
            textTransform: "none",
          }}
        >
          Check In
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default InputDialog;
