package concurrency

import (
	"context"
	"fmt"
)

func main() {
	ProcessRequest("jane", "abc123")
}

type ctxKey int

const (
	ctxUserId ctxKey = iota
	ctxAuthToken
)

func UserId(c context.Context) string {
	return c.Value(ctxUserId).(string)
}

func AuthToken(c context.Context) string {
	return c.Value(ctxAuthToken).(string)
}
func ProcessRequest(userId, authToken string) {
	ctx := context.WithValue(context.Background(), ctxUserId, userId)
	ctx = context.WithValue(ctx, ctxAuthToken, authToken)
	HandleRequest(ctx)
}
func HandleRequest(ctx context.Context) {
	fmt.Printf(
		"handling response for %v (%v)",
		UserId(ctx),
		AuthToken(ctx),
	)
}

func ProcessRequest0(userId, authToken string) {
	ctx := context.WithValue(context.Background(), "userId", userId)
	ctx = context.WithValue(ctx, "authToken", authToken)
	HandleRequest(ctx)
}
func HandleRequest0(ctx context.Context) {
	fmt.Printf(
		"handling response for %v (%v)",
		ctx.Value("userId"),
		ctx.Value("authToken"),
	)
}
