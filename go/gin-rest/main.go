package main

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"net/http"
)

func get_root(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{
		"message": "root",
	})
}

func get_ping(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{
		"message": "pong",
	})
}

func main() {
	r := gin.Default()
	r.GET("/", get_root)
	r.GET("/ping", get_ping)

	port := ":8182"
	fmt.Println("\nView REST API http://127.0.0.1" + port + "\n")

	r.Run(port)
}
