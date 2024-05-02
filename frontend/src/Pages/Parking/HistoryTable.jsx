import React, { useEffect, useState } from "react";
import {
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableContainer,
  TableCell,
  Paper,
  Grid,
} from "@mui/material";
import Sidebar from "../../Components/Parking/Sidebar";
import axios from "axios";
import { API_URL } from "../../constants/urls";

const HistoryTable = () => {
  const [data, setData] = useState([]);

  const fetchSlotHistories = async () => {
    try {
      const response = await axios.get(`${API_URL}/slotHistory`);
      return response.data;
    } catch (error) {
      console.error("Error fetching slot histories:", error);
      return [];
    }
  };

  useEffect(() => {
    fetchSlotHistories().then((data) => {
      setData(data);
    });
  }, []);

  const tableHeaderStyle = {
    backgroundColor: "rgba(101,95,245,0.6)",
    color: "#0C0C0C",
    fontWeight: "bold",
  };

  const tableCellStyle = {
    borderBottom: "1px solid #e0e0e0",
    padding: "10px",
  };

  // if (!data || !Array.isArray(data) || data.length === 0) {
  //   return <div>No data available</div>;
  // }

  return (
    <>
      <Grid
        sx={{
          mt: 13,
        }}
      >
        <Sidebar />
        <TableContainer
          component={Paper}
          elevation={0}
          sx={{ border: "1px solid rgba(228,237,255,255)" }}
        >
          <Table>
            <TableHead>
              <TableRow>
                <TableCell style={tableHeaderStyle}>Name</TableCell>
                <TableCell style={tableHeaderStyle}>NIC</TableCell>
                <TableCell style={tableHeaderStyle}>Slot Number</TableCell>
                <TableCell style={tableHeaderStyle}>Vehicle Number</TableCell>
                <TableCell style={tableHeaderStyle}>Vehicle Type</TableCell>
                <TableCell style={tableHeaderStyle}>Date</TableCell>
                <TableCell style={tableHeaderStyle}>Check-in Time</TableCell>
                <TableCell style={tableHeaderStyle}>Check-out Time</TableCell>
                <TableCell style={tableHeaderStyle}>Payment</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {data &&
                data.map((row, index) => (
                  <TableRow
                    key={index}
                    style={
                      index % 2 === 1
                        ? { backgroundColor: "rgb(192,198,203)" }
                        : {}
                    }
                  >
                    <TableCell
                      style={{
                        ...tableCellStyle,
                        color: "blue",
                        fontWeight: "bold",
                      }}
                    >
                      {row.name}
                    </TableCell>
                    <TableCell style={tableCellStyle}>{row.nic}</TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.slotNumber}
                    </TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.vehicleNumber}
                    </TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.vehicleType}
                    </TableCell>
                    <TableCell style={tableCellStyle}>{row.date}</TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.checkInTime}
                    </TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.checkOutTime === ""
                        ? "Still parked"
                        : row.checkOutTime}
                    </TableCell>
                    <TableCell style={tableCellStyle}>
                      {row.payment === 0
                        ? "Still parked"
                        : `Rs.${row.payment}.00`}
                    </TableCell>
                  </TableRow>
                ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Grid>
    </>
  );
};

export default HistoryTable;
