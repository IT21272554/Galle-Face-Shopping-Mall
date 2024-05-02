import React, { useEffect, useState } from "react";
import Grid from "@mui/material/Grid";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import MenuItem from "@mui/material/MenuItem";
import CarIcon from "@mui/icons-material/DirectionsCar";
import VanIcon from "@mui/icons-material/LocalShipping";
import BikeIcon from "@mui/icons-material/TwoWheeler";
import ThreeWheelerIcon from "@mui/icons-material/ElectricRickshaw";
import Sidebar from "../../Components/Parking/Sidebar";
import axios from "axios";
import { API_URL } from "../../constants/urls";
import InputDialog from "../../Components/Parking/InputDialog";

const GridItems = () => {
  const [slots, setSlots] = useState([]);
  const [open, setOpen] = useState(false);
  const [selectedSlot, setSelectedSlot] = useState({});

  const [availableSlots, setAvailableSlots] = useState(0);
  const [bookedSlots, setBookedSlots] = useState(0);

  const vehicleIcons = {
    Car: <CarIcon sx={{ fontSize: "30px" }} />,
    Van: <VanIcon sx={{ fontSize: "30px" }} />,
    Bike: <BikeIcon sx={{ fontSize: "30px" }} />,
    "Three Wheeler": <ThreeWheelerIcon sx={{ fontSize: "30px" }} />,
  };

  useEffect(() => {
    axios
      .get(`${API_URL}/slot/all`)
      .then((response) => {
        console.log(response.data);
        setSlots(response.data);

        // Calculate the available and checked slots counts
        let availableCount = 0;
        let bookedCount = 0;

        response.data.forEach((slot) => {
          if (slot.isBooked) {
            bookedCount++;
          } else {
            availableCount++;
          }
        });

        // Set the available and checked slots states
        setAvailableSlots(availableCount);
        setBookedSlots(bookedCount);
      })
      .catch((error) => {
        console.error("There was an error!", error);
      });
  }, []);

  const handleCardClick = (slot) => {
    setOpen(true);
    setSelectedSlot(slot);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div
      style={{
        width: "100%",
        height: "100vh",
      }}
    >
      <Grid
        container
        spacing={2}
        sx={{ height: "100%", display: "flex", alignItems: "start" }}
      >
        <Grid>
          <Sidebar />
        </Grid>

        {/* head */}
        <Grid
          container
          item
          direction="row"
          style={{ paddingTop: "0px" }}
          sx={{
            pt: 0,
            mt: 10,
            borderRadius: "10px",
            border: "2px dashed rgba(228,237,255,255)",
          }}
        >
          <Grid container item xs={3} sx={{ p: 0 }}>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "100%",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent>
                  <Typography
                    sx={{ fontWeight: "bold" }}
                    variant="h7"
                    textTransform={"uppercase"}
                  >
                    Vehicles
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          </Grid>
          <Grid container item xs={9}>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent
                  sx={{
                    display: "flex",
                    flexDirection: "row",
                    columnGap: "10px",
                    alignItems: "center",
                  }}
                >
                  <CarIcon sx={{ fontSize: "30px" }} />
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Car
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent
                  sx={{
                    display: "flex",
                    flexDirection: "row",
                    columnGap: "10px",
                    alignItems: "center",
                  }}
                >
                  <VanIcon sx={{ fontSize: "30px" }} />
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Van
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent
                  sx={{
                    display: "flex",
                    flexDirection: "row",
                    columnGap: "10px",
                    alignItems: "center",
                  }}
                >
                  <BikeIcon sx={{ fontSize: "30px" }} />
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Bike
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent
                  sx={{
                    display: "flex",
                    flexDirection: "row",
                    columnGap: "10px",
                    alignItems: "center",
                  }}
                >
                  <ThreeWheelerIcon sx={{ fontSize: "30px" }} />
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Three Wheel
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          </Grid>
        </Grid>

        {/* slots */}
        <Grid
          container
          item
          sx={{
            display: "flex",
            alignItems: "center",
            borderRadius: "10px",
            bgcolor: "rgba(228,237,255,255)",
          }}
        >
          <Grid item sx={{ width: "100%", py: 6 }}>
            {slots &&
              Array.from({ length: 2 }, (_, rowIndex) => (
                <Grid
                  container
                  item
                  key={rowIndex}
                  xs={12}
                  spacing={2}
                  sx={{
                    width: "100%",
                    display: "flex",
                    justifyContent: "center",
                    mb: 4,
                  }}
                >
                  {slots
                    .slice(rowIndex * 10, rowIndex * 10 + 10)
                    .map((slot, colIndex) => {
                      return (
                        <Grid
                          container
                          item
                          key={slot._id}
                          xs={12}
                          sm={1}
                          md={1}
                          lg={1}
                        >
                          <Grid item>
                            <Card
                              variant="outlined"
                              sx={{
                                height: "110px",
                                width: "70px",
                                borderRadius: "5px",
                                border: "2px dashed #bebeb6",
                              }}
                              style={{ cursor: "pointer" }}
                              onClick={() => handleCardClick(slot)}
                            >
                              <CardContent>
                                <Typography
                                  sx={{
                                    fontSize: "16px",
                                    color: "rgb(37, 150, 190)",
                                    fontWeight: "bold",
                                  }}
                                >
                                  {slot.slotNumber}
                                </Typography>
                                {slot.isBooked &&
                                  slot.vehicleType &&
                                  vehicleIcons[slot.vehicleType]}
                              </CardContent>
                            </Card>
                          </Grid>
                        </Grid>
                      );
                    })}
                </Grid>
              ))}
          </Grid>
        </Grid>
        {/* parking slot details */}
        <Grid
          container
          item
          direction="row"
          style={{ paddingTop: "0px" }}
          sx={{
            borderRadius: "10px",
            bgcolor: "rgba(228,237,255,255)",
          }}
        >
          <Grid container item xs={6}>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "100%",
                  height: "100px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent>
                  <Typography
                    sx={{ fontWeight: "bold" }}
                    variant="h7"
                    textTransform={"uppercase"}
                  >
                    Parking Slot Details
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          </Grid>
          <Grid container item xs={6}>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  height: "100px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent>
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Booked Slots
                  </Typography>
                  <Typography variant="h5" sx={{ fontWeight: "bold" }}>
                    {bookedSlots}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
            <Grid item>
              <Card
                variant="outlined"
                sx={{
                  width: "200px",
                  height: "100px",
                  bgcolor: "transparent",
                  border: "none",
                }}
              >
                <CardContent>
                  <Typography sx={{ fontWeight: "bold", color: "gray" }}>
                    Available Slots
                  </Typography>
                  <Typography variant="h5" sx={{ fontWeight: "bold" }}>
                    {availableSlots}
                  </Typography>
                </CardContent>
              </Card>
            </Grid>
          </Grid>
        </Grid>
      </Grid>

      <InputDialog
        open={open}
        handleClose={handleClose}
        selectedSlot={selectedSlot}
        slots={slots}
        setSlots={setSlots}
        setBookedSlots={setBookedSlots}
        setAvailableSlots={setAvailableSlots}
      />
    </div>
  );
};

export default GridItems;
